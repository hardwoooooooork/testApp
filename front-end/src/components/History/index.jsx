import React, { Component } from 'react'
import HistoryLayout from './HistoryLayout';

import * as user from '../../services/login'

export default class History extends Component {
    state={ 
        historyData : [],
    }

    componentDidMount(){
        this.getUserHistory().then(historyData => this.setState({historyData}));
    }

    getUserHistory = async ()=>{
        try {
            const res = await user.getUserInfoKeyword();            
            return res.data;
        } catch (error) {
            return undefined;
        }
    }

    render() {
        return (
            <HistoryLayout
                {...this.props}
                {...this.state}
            />
        )
    }
}
