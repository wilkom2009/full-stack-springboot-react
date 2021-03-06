import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";
import {Link, withRouter } from 'react-router-dom'

class HeaderComponent extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <header>
                <nav className="navbar navbar-expand navbar-dark bg-dark  topbar mb-4 static-top shadow">
                    <div><a href="https://www.linkedin.com/in/wilkom2009" className="navbar-brand">Wilkom2009</a></div>
                    <ul className="navbar-nav ">
                        {isUserLoggedIn && <li><Link className="nav-link " to="/welcome/Wil">Home</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link " to="/todos">Todos</Link></li>}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li><Link className="nav-link " to="/login">Login</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link " to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default withRouter(HeaderComponent)