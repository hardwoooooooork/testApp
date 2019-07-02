import React, { Component } from 'react'
import UserJoinLayout from './UserJoinLayout';
import * as user from '../../services/login'

export default class UserJoin extends Component {

    state = { modalOpen: false, formData:{} }

    handleOpen = () => this.setState({ modalOpen: true })

    handleClose = () => this.setState({ modalOpen: false })
    
    onChangeHandler = (e) => this.setState({ formData: { ...this.state.formData, [e.target.name]: e.target.value } })

    onsubmitHandler = async () => {
        try {
            const res = await user.userJoin(this.state.formData);
            //console.log(res);
            
            if (res.status === 200) {
                alert("가입이 완료되었습니다.")
                this.setState({ modalOpen: false, formData: {} })
            }
        } catch (error) {
            alert("가입 에러 발생")
        }
        
    }
    render() {
        return (
            <UserJoinLayout
                handleOpen={this.handleOpen}
                handleClose={this.handleClose}
                onChangeHandler={this.onChangeHandler}
                onsubmitHandler={this.onsubmitHandler}
                {...this.state}
            />
        )
    }
}
