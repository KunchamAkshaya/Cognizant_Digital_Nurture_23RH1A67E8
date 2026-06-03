console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
  alert("Community Portal Loaded Successfully!");
});


const eventsContainer = document.querySelector("#eventsContainer");
const categoryFilter = document.querySelector("#categoryFilter");
const searchInput = document.querySelector("#searchInput");
const loader = document.querySelector("#loader");
const registrationForm = document.querySelector("#registrationForm");
const messageBox = document.querySelector("#messageBox");
const eventDropdown = registrationForm.elements["event"];

let events = [];
let totalRegistrations = 0;


class Event {
  constructor(
    id,
    name,
    date,
    category,
    location,
    seats,
    description,
    image
  ) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.category = category;
    this.location = location;
    this.seats = seats;
    this.description = description;
    this.image = image;
  }
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};


// Closure Example
function registrationTracker() {
  let count = 0;

  return function () {
    count++;
    return count;
  };
}

const trackMusicRegistrations = registrationTracker();

// Add Event Function
function addEvent(eventObject) {
  events.push(eventObject);
}

// Register User Function
function registerUser(eventId) {
  try {
    const event = events.find((e) => e.id === eventId);

    if (!event) {
      throw new Error("Event not found");
    }

    if (event.seats <= 0) {
      throw new Error("No seats available");
    }

    event.seats--;

    totalRegistrations++;

    if (event.category === "Music") {
      console.log(
        "Music Registrations:",
        trackMusicRegistrations()
      );
    }

    updateStats();
    renderEvents(events);

    return true;
  } catch (error) {
    alert(error.message);
    console.error(error);
    return false;
  }
}

function filterEventsByCategory(category, callback) {
  const clonedEvents = [...events];

  let filtered =
    category === "all"
      ? clonedEvents
      : clonedEvents.filter(
          (event) => event.category === category
        );

  callback(filtered);
}

fetch("events.json")
  .then((response) => response.json())
  .then((data) => {
    initializeEvents(data);
  })
  .catch((error) => {
    console.error("Fetch Error:", error);
  });

async function initializeEvents(data) {
  try {
    loader.classList.remove("hidden");

    await new Promise((resolve) =>
      setTimeout(resolve, 1500)
    );

    events = data.map(
      ({
        id,
        name,
        date,
        category,
        location,
        seats,
        description,
        image,
      }) =>
        new Event(
          id,
          name,
          date,
          category,
          location,
          seats,
          description,
          image
        )
    );


    
    const musicEvents = events.filter(
      (event) => event.category === "Music"
    );

    console.log("Music Events:", musicEvents);

    
    const eventTitles = events.map(
      (event) => `Workshop on ${event.name}`
    );

    console.log(eventTitles);

    renderEvents(events);
    populateDropdown(events);
    updateStats();

    loader.classList.add("hidden");
  } catch (error) {
    console.error(error);
  }
}


function renderEvents(eventList) {
  eventsContainer.innerHTML = "";

  eventList.forEach((event) => {
    const currentDate = new Date();
    const eventDate = new Date(event.date);

    if (eventDate < currentDate || event.seats <= 0) {
      return;
    }

    const card = document.createElement("div");
    card.classList.add("event-card");

    console.log(Object.entries(event));

    card.innerHTML = `

      <div class="event-content">
        <h3>${event.name}</h3>

        <p>${event.description}</p>

        <p><strong>Category:</strong> ${event.category}</p>

        <p><strong>Date:</strong> ${event.date}</p>

        <p><strong>Location:</strong> ${event.location}</p>

        <p class="seat-warning">
          🔥 Only ${event.seats} Seats Left!
        </p>

        <button class="register-btn">
          Register Now
        </button>

        <button class="cancel-btn">
          Cancel Seat
        </button>
      </div>
    `;

    const registerBtn = card.querySelector(".register-btn");
    const cancelBtn = card.querySelector(".cancel-btn");

    
    registerBtn.onclick = () => {
      const success = registerUser(event.id);

      if (success) {
        $(card).fadeOut(200).fadeIn(200);
      }
    };

    cancelBtn.onclick = () => {
      event.seats++;
      totalRegistrations--;

      renderEvents(events);
      updateStats();
    };

    eventsContainer.appendChild(card);
  });
}

// =====================================
// Update Stats
// =====================================

function updateStats() {
  document.querySelector("#eventCount").textContent =
    events.length;

  document.querySelector("#registrationCount").textContent =
    totalRegistrations;
}


function populateDropdown(eventList) {
  eventList.forEach((event) => {
    const option = document.createElement("option");

    option.value = event.id;

    option.textContent = `${event.name} (${event.seats} seats left)`;

    eventDropdown.appendChild(option);
  });
}


categoryFilter.onchange = (e) => {
  filterEventsByCategory(e.target.value, renderEvents);
};



searchInput.addEventListener("keydown", () => {
  const keyword = searchInput.value.toLowerCase();

  const filtered = events.filter((event) =>
    event.name.toLowerCase().includes(keyword)
  );

  renderEvents(filtered);
});



registrationForm.addEventListener("submit", async (event) => {
  // preventDefault()
  event.preventDefault();

  console.log("Form Submitted");

  const name = registrationForm.elements["name"];
  const email = registrationForm.elements["email"];
  const selectedEvent = registrationForm.elements["event"];

  clearErrors();

  let valid = true;

  // Validation
  if (name.value.trim() === "") {
    showError(name, "Name is required");
    valid = false;
  }

  if (!email.value.includes("@")) {
    showError(email, "Valid email required");
    valid = false;
  }

  if (selectedEvent.value === "") {
    showError(selectedEvent, "Select an event");
    valid = false;
  }

  if (!valid) {
    return;
  }

  const payload = {
    name: name.value,
    email: email.value,
    eventId: selectedEvent.value,
  };

  console.log("Payload:", payload);



  try {
    messageBox.textContent = "Sending Registration...";

    // setTimeout()
    await new Promise((resolve) =>
      setTimeout(resolve, 2000)
    );

    const response = await fetch(
      "https://jsonplaceholder.typicode.com/posts",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
      }
    );

    if (!response.ok) {
      throw new Error("Failed to register");
    }

    messageBox.textContent =
      "✅ Registration Successful!";

    registerUser(Number(selectedEvent.value));

    registrationForm.reset();
  } catch (error) {
    messageBox.textContent =
      "❌ Registration Failed";

    console.error(error);
  }
});



function showError(input, message) {
  input.parentElement.querySelector(".error").textContent =
    message;
}

function clearErrors() {
  document.querySelectorAll(".error").forEach((error) => {
    error.textContent = "";
  });
}



$(document).ready(function () {
  // jQuery click()
  $("#registerBtn").click(function () {
    $("html, body").animate(
      {
        scrollTop: $(".events-section").offset().top,
      },
      1000
    );
  });
});


console.log(
  "Frameworks like React and Vue make applications scalable, reusable, and easier to maintain."
);