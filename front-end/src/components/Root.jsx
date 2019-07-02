import React, { Component } from 'react'
import { HashRouter } from 'react-router-dom';
import Layout from './layouts'

export default class Root extends Component {
    render() {
        return (
            <HashRouter>
                <Layout
                    {...this.props}
                />
            </HashRouter>
        )
    }
}
