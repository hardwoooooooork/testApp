import React, { Component } from 'react'
import LoginLayout from './LoginLayout'
export default class Login extends Component {
    state={
        formData:{},
    }
    
    render() {
        return (
            <LoginLayout
                formData={this.state.formData} 
            />
        )
    }
}
