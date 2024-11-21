// frontend/src/App.js
import React, { useState } from "react";
import axios from "axios";
import "./App.css"; // CSS file for styling

const App = () => {
  const [longUrl, setLongUrl] = useState(""); // For input URL
  const [shortUrl, setShortUrl] = useState(""); // For generated short URL
  const [error, setError] = useState(""); // To show error messages

  const handleGenerate = async (e) => {
    e.preventDefault(); // Prevent form reload
    setError("");
    setShortUrl("");

    if (!longUrl.trim()) {
      setError("Please enter a valid URL.");
      return;
    }

    try {
      // Make API request to Spring Boot backend
      const response = await axios.post("/gg/generate", longUrl, {
        headers: { "Content-Type": "text/plain" },
      });

      // Update the short URL
      setShortUrl(`http://localhost:8080/gg/${response.data}`);
    } catch (err) {
      setError("Error generating short URL.");
    }
  };

  const handleCopy = () => {
    navigator.clipboard
        .writeText(shortUrl)
        .then(() => {
          alert("Short URL copied to clipboard!");
        })
        .catch(() => {
          alert("Failed to copy short URL.");
        });
  };

  return (
      <div className="container">
        <h2>URL Shortener</h2>
        <form onSubmit={handleGenerate}>
          <input
              type="text"
              placeholder="Enter long URL"
              value={longUrl}
              onChange={(e) => setLongUrl(e.target.value)}
          />
          <button type="submit">Generate</button>
        </form>
        {error && <div className="error">{error}</div>}
        {shortUrl && (
            <div className="result">
              <p>
                <strong>Short URL:</strong>{" "}
                <a href={shortUrl} target="_blank" rel="noopener noreferrer">
                  {shortUrl}
                </a>
              </p>
              <button onClick={handleCopy}>Copy Short URL</button>
            </div>
        )}
      </div>
  );
};

export default App;
