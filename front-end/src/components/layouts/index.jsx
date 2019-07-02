import React, { Component } from 'react'
import { Route, Redirect } from 'react-router-dom';

import Login from './login';
import Main from './main'

export default class index extends Component {
    render() {
        return (
            <React.Fragment>
                <Route exact path="/" render={() => <Redirect to='/login' /> } />
                <Route exact path="/login" component={Login} />
                <Route exact path="/main" component={Main} />
            </React.Fragment>
        )
    }
}
