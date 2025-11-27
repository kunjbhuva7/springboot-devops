package com.app.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // =================== LOGIN PAGE ===================
    @GetMapping(value = "/", produces = "text/html")
    public String loginPage() {
        return """
        <html>
        <head>
            <title>DevOps Login</title>

            <style>
                body {
                    margin: 0;
                    height: 100vh;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    font-family: 'Poppins', sans-serif;
                    background: radial-gradient(circle at top, #2c3e50, #000000);
                    animation: fadeIn 1.5s ease-in-out;
                }

                @keyframes fadeIn {
                    0% { opacity: 0; transform: scale(0.9); }
                    100% { opacity: 1; transform: scale(1); }
                }

                .box {
                    width: 380px;
                    padding: 35px;
                    border-radius: 18px;
                    background: rgba(255, 255, 255, 0.15);
                    backdrop-filter: blur(12px);
                    box-shadow: 0 8px 40px rgba(0, 0, 0, 0.4);
                    animation: slideUp 1.2s ease;
                    color: white;
                }

                @keyframes slideUp {
                    0% { transform: translateY(40px); opacity: 0; }
                    100% { transform: translateY(0); opacity: 1; }
                }

                .box h2 {
                    text-align: center;
                    margin-bottom: 25px;
                    font-size: 28px;
                    letter-spacing: 2px;
                    animation: glowText 2s infinite;
                }

                @keyframes glowText {
                    0%,100% { text-shadow: 0 0 8px #00eaff; }
                    50% { text-shadow: 0 0 20px #00eaff; }
                }

                .input-container {
                    background: rgba(255,255,255,0.2);
                    padding: 12px 15px;
                    border-radius: 10px;
                    margin-bottom: 18px;
                    display: flex;
                    align-items: center;
                    transition: 0.3s;
                }

                .input-container:hover {
                    background: rgba(255,255,255,0.3);
                }

                input {
                    width: 100%;
                    border: none;
                    outline: none;
                    background: transparent;
                    color: white;
                    font-size: 16px;
                    margin-left: 10px;
                }

                .btn {
                    width: 100%;
                    padding: 12px;
                    margin-top: 10px;
                    background: linear-gradient(45deg, #00eaff, #007bff);
                    border: none;
                    border-radius: 10px;
                    color: white;
                    font-size: 18px;
                    cursor: pointer;
                    transition: 0.3s;
                }

                .btn:hover {
                    background: linear-gradient(45deg, #00c2d4, #005fcc);
                    transform: scale(1.03);
                }

            </style>

            <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
        </head>


        <body>
            <div class="box">
                <h2>LOGIN</h2>

                <form action="/auth" method="GET">
                    <div class="input-container">
                        <i class="fa fa-user"></i>
                        <input type="text" name="username" placeholder="username" required>
                    </div>

                    <div class="input-container">
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



    // =================== LOGIN SUCCESS PAGE ===================
    @GetMapping(value = "/auth", produces = "text/html")
    public String auth(@RequestParam String username,
                       @RequestParam String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return """
            <html>
            <head>
                <style>
                    body {
                        background: radial-gradient(circle, #001f3f, #000000);
                        height: 100vh;
                        margin: 0;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        animation: fadeIn 1.5s ease-in-out;
                        color: white;
                        font-family: 'Poppins', sans-serif;
                    }

                    @keyframes fadeIn {
                        0% { opacity: 0; transform: scale(0.9); }
                        100% { opacity: 1; transform: scale(1); }
                    }

                    h1 {
                        font-size: 55px;
                        font-weight: bold;
                        animation: glow 2s infinite alternate;
                    }

                    @keyframes glow {
                        from { text-shadow: 0 0 10px cyan; }
                        to { text-shadow: 0 0 25px #00eaff; }
                    }
                </style>
            </head>

            <body>
                <h1>Hello DevOps! 🚀</h1>
            </body>
            </html>
            """;
        }


        return """
            <html>
            <body style='display:flex; justify-content:center; align-items:center; height:100vh; background:black; color:red; font-size:32px;'>
                ❌ Invalid Credentials
            </body>
            </html>
        """;
    }
}

