import React, { Component } from 'react';
import './App.css';
import 'semantic-ui-css/semantic.min.css'
import Root from './components/Root'

export default class App extends Component {
  state = {
    isLogin : {}
  }
  render() {
    return (
      <Root
        {...this.state}
      />
    )
  }
}
