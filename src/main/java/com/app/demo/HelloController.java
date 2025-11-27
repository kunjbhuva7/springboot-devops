package com.app.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // LOGIN PAGE UI
    @GetMapping(value = "/", produces = "text/html")
    public String loginPage() {
        return """
        <html>
        <head>
            <title>Login</title>
            <style>
                body {
                    margin: 0;
                    padding: 0;
                    height: 100vh;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    font-family: Arial, sans-serif;
                    background: linear-gradient(135deg, #2b4141, #94a892);
                }

                .box {
                    width: 360px;
                    padding: 30px;
                    background: rgba(255, 255, 255, 0.15);
                    border-radius: 12px;
                    backdrop-filter: blur(10px);
                    box-shadow: 0 4px 25px rgba(0,0,0,0.2);
                    text-align: center;
                }

                .box h2 {
                    color: white;
                    margin-bottom: 25px;
                    font-size: 28px;
                    font-weight: bold;
                }

                .input-container {
                    background: rgba(255, 255, 255, 0.2);
                    margin-bottom: 18px;
                    padding: 10px 14px;
                    border-radius: 8px;
                    display: flex;
                    align-items: center;
                }

                .input-container input {
                    width: 100%;
                    border: none;
                    background: transparent;
                    outline: none;
                    color: white;
                    font-size: 16px;
                    margin-left: 10px;
                }

                .input-container i {
                    color: white;
                    font-size: 18px;
                }

                .btn {
                    width: 100%;
                    padding: 12px;
                    background: #1e1e1e;
                    color: white;
                    border: none;
                    border-radius: 8px;
                    font-size: 18px;
                    cursor: pointer;
                    margin-top: 10px;
                }

                .btn:hover {
                    background: #333;
                }
            </style>

            <!-- Icons -->
            <link rel="stylesheet"
                  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
        </head>

        <body>
            <div class='box'>
                <h2>LOGIN</h2>

                <form action="/auth" method="GET">
                    <div class='input-container'>
                        <i class="fa fa-user"></i>
                        <input type="text" name="username" placeholder="username" required>
                    </div>

                    <div class='input-container'>
                        <i class="fa fa-lock"></i>
                        <input type="password" name="password" placeholder="password" required>
                    </div>

                    <button class="btn" type="submit">Sign In</button>
                </form>
            </div>
        </body>
        </html>
        """;
    }

    // AUTH + SUCCESS PAGE
    @GetMapping(value = "/auth", produces = "text/html")
    public String auth(@RequestParam String username,
                       @RequestParam String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return """
                <html>
                <body style='display:flex; justify-content:center; align-items:center; height:100vh;'>
                    <h1 style='font-size:55px; font-weight:bold; color:#222;'>Hello DevOps!</h1>
                </body>
                </html>
            """;
        }

        return """
            <html>
            <body style='display:flex; justify-content:center; align-items:center; height:100vh; color:red;'>
                <h2>Invalid Credentials ❌</h2>
            </body>
            </html>
        """;
    }
}

