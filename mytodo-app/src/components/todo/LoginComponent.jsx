import React, { Component } from "react";
import AuthenticationService from "./AuthenticationService.js";

class LoginComponent extends Component {

    //create an initial state
    constructor(props) {
        super(props)

        this.state = {
            username: 'will',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value })
    }

    loginClicked() {
        /**AuthenticationService.executeBasicAuthenticationService(this.state.username, this.state.password)
            .then(() => {
                AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password)
                this.props.history.push(`/welcome/${this.state.username}`)
            })
            .catch(() => {
                this.setState(
                    {
                        showSuccessMessage: false,
                        hasLoginFailed: true
                    })
            })*/


        AuthenticationService.executeJwtAuthenticationService(this.state.username, this.state.password)
            .then((response) => {
                AuthenticationService.registerSuccessfulLoginForJwt(this.state.username, response.data.token)
                this.props.history.push(`/welcome/${this.state.username}`)
            })
            .catch(() => {
                this.setState(
                    {
                        showSuccessMessage: false,
                        hasLoginFailed: true
                    })
            })
    }

    render() {
        return (
            <div><div className="container">
                <div className="row justify-content-center">
                    <div className="col-xl-10 col-lg-12 col-md-9">

                        <div className="card o-hidden border-0 shadow-lg my-5">
                            <div className="card-body p-0">

                                <div className="row">
                                    <div className="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                    <div className="col-lg-6">
                                        <div className="p-5">
                                            <div className="text-center">
                                                <h1 className="h4 text-gray-900 mb-4">LOGIN</h1>
                                            </div>
                                            {this.state.hasLoginFailed && <div className="alert alert-danger">Invalid credentials</div>}
                                            <div className="form-group">
                                                <input type="text" name="username"
                                                    className="form-control form-control-user"
                                                    id="usernameId"
                                                    placeholder="Enter User name..." value={this.state.username} onChange={this.handleChange} />
                                            </div>
                                            <div className="form-group">
                                                <input type="password" name="password"
                                                    className="form-control form-control-user"
                                                    id="passwordId" placeholder="Enter Password..." value={this.state.password} onChange={this.handleChange} />
                                            </div>
                                            <button className="btn btn-primary btn-user btn-block" onClick={this.loginClicked}>Login</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            </div>
        )
    }
}

export default LoginComponent