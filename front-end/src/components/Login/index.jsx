import React, { Component } from 'react'
import LoginLayout from './LoginLayout.jsx'
import * as users from '../../services/login'

export default class Login extends Component {
    state={
        formData:{},
    }

    onChangeHandler = (e) => this.setState({ formData : {...this.state.formData, [e.target.name] : e.target.value} });
    onSubmitHandler = async(e) => {
        try {
            const res = await users.getUserInfo(this.state.formData);            
            if(res.status === 200){
                localStorage.setItem('auth', JSON.stringify(this.state.formData));
                window.location.href = '/';
            }
            
        } catch (error) {
            //console.log(error);
            alert('login fail!')
        }
    }

    render() {
        return (
            <LoginLayout
                formData={this.state.formData} 
                onChangeHandler={this.onChangeHandler}
                onSubmitHandler={this.onSubmitHandler}
            />
        )
    }
}
