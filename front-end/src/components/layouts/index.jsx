import React, { Component } from 'react'
import { Route, Redirect } from 'react-router-dom';

import Login from './login.jsx';
import Main from './main.jsx'
import * as user from '../../services/login'

export default class index extends Component {
    state = { isLogin: user.loginCheck(), }
    
    render() {
        const isLogin = this.state.isLogin;
        if(isLogin){
            return (
                <React.Fragment>
                    <Route exact path="/" render={() => <Redirect to='/main' />} />
                    <Route exact path="/login" render={() => <Redirect to='/main' />} />
                    <Route exact path="/main" component={Main} />
                </React.Fragment>
            )
        }else{
            return (
                <React.Fragment>
                    <Route path="/*" render={() => <Redirect to='/login' />} />
                    <Route exact path="/login" component={Login} />
                </React.Fragment>
            )
        }
    }
}
