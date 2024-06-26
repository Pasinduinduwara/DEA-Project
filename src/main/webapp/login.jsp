<%--
  Created by IntelliJ IDEA.
  User: Ayodya
  Date: 5/1/2024
  Time: 8:11 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/login.css">
    <title>signup</title>
</head>
<body>
<!-- sign in form -->
<div class="container">
    <div class="signin-signup">
        <form action="####" method="post" class="sign-in-form">
            <h2 class="title">Sign in</h2>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Username">
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password">
            </div>
            <input type="submit" value="Sign in" class="btn">
            <p class="social-text">Or Sign in with social platform</p>
            <div class="social-media">
                <a href="https://www.facebook.com/profile.php?id=100095176400057" class="social-icon">
                    <i class="fab fa-facebook"></i>
                </a>
                <a href="https://instagram.com/salonforglamour?igshid=MzNlNGNkZWQ4Mg==" class="social-icon">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="https://www.google.com/index.html" class="social-icon">
                    <i class="fab fa-google"></i>
                </a>
            </div>
            <p class="account-text">Don't have an account? <a href="#" id="sign-up-btn2">Sign up</a></p>
        </form>

        <!-- sign up form -->
        <form action="" class="sign-up-form">
            <h2 class="title">Sign up</h2>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Username">
            </div>
            <div class="input-field">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Email">
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password">
            </div>
            <input type="submit" value="Sign up" class="btn">
            <p class="social-text">Or Sign in with social platform</p>
            <div class="social-media">
                <a href="https://www.facebook.com/profile.php?id=100095176400057" class="social-icon">
                    <i class="fab fa-facebook"></i>
                </a>
                <a href="https://instagram.com/salonforglamour?igshid=MzNlNGNkZWQ4Mg==" class="social-icon">
                    <i class="fab fa-instagram"></i>
                </a>
                <a href="www.google.com" class="social-icon">
                    <i class="fab fa-google"></i>
                </a>

            </div>
            <p class="account-text">Already have an account? <a href="#" id="sign-in-btn2">Sign in</a></p>
        </form>
    </div>
    <div class="panels-container">
        <div class="panel left-panel">
            <div class="content">
                <h3>Member of Brand?</h3>
                <p>"Welcome to our salon's online platform! Please log in to access exclusive offers and convenient booking services."</p>
                <button class="btn" id="sign-in-btn">Sign in</button>
            </div>
            <img src="images/undraw_undraw_undraw_undraw_sign_up_ln1s_-1-_s4bc_-1-_ee41_-1-_3xti" alt="" class="image">
        </div>
        <div class="panel right-panel">
            <div class="content">
                <h3>New to our paradise</h3>
                <p>"Welcome to Saloon Asia, where exotic flavors and vibrant culture await your palate and senses!"</p>
                <button class="btn" id="sign-up-btn">Sign up</button>
            </div>
            <img src="signup.svg" alt="" class="image">
        </div>
    </div>
</div>
<script src="js/login.js"></script>
</body>
</html>
