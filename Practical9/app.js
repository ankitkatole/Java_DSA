const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.urlencoded({ extended: true }));

const db = new sqlite3.Database(':memory:');

db.serialize(() => {
  db.run('CREATE TABLE users (username TEXT, password TEXT)');
  db.run("INSERT INTO users (username, password) VALUES ('admin', 'admin123')");
  db.run("INSERT INTO users (username, password) VALUES ('user', 'user123')");
});

app.post('/login', (req, res) => {
  const { username, password } = req.body;

  const sql = `SELECT * FROM users WHERE username = '${username}' AND password = '${password}'`;

  db.get(sql, (err, row) => {
    if (err) {
      return res.status(500).send('Database error');
    }
    if (row) {
      res.send(`<h1>Welcome, ${row.username}!</h1><p>Logged in Successfully.</p>`);
    } else {
      res.send('<h1>Login Failed</h1><p>Invalid username or password.</p><a href="/">Try again</a>');
    }
  });
});

app.get('/', (req, res) => {
  res.send(`
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
        <style>
            body {
                font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
                background-color: #f0f2f5;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .login-container {
                background-color: #ffffff;
                padding: 2rem 3rem;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
                text-align: center;
            }
            h2 {
                color: #1c1e21;
                margin-bottom: 1.5rem;
                font-size: 24px;
            }
            .input-group {
                margin-bottom: 1rem;
                text-align: left;
            }
            label {
                display: block;
                margin-bottom: 0.5rem;
                color: #606770;
                font-weight: 600;
            }
            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 12px;
                border: 1px solid #dddfe2;
                border-radius: 6px;
                box-sizing: border-box;
                font-size: 16px;
            }
            input:focus {
                outline: none;
                border-color: #1877f2;
                box-shadow: 0 0 0 2px #e7f3ff;
            }
            button {
                width: 100%;
                padding: 12px;
                border: none;
                border-radius: 6px;
                background-color: #1877f2;
                color: white;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
                transition: background-color 0.2s;
            }
            button:hover {
                background-color: #166fe5;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Login to Your Account</h2>
            <form method="POST" action="/login">
                <div class="input-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
    </html>
  `);
});

app.listen(3000, () => console.log('Server running on http://localhost:3000'));