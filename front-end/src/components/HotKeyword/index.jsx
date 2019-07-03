import React, { Component } from 'react'
import HotKeywordLayout from './HotKeywordLayout'
import * as mapApi from '../../services/maps'

export default class HotKeyword extends Component {
    state = { 
        HotKeywordList : [],
    }

    intervalId = null;

    componentDidMount(){
        this.getHotKeyword().then(()=>{
            this.intervalId = setInterval( this.getHotKeyword , 3000);
        })
    }

    componentWillUnmount(){
        try {
            clearInterval(this.intervalId)            
        } catch (error) {
        }
    }

    /**
     * 인기 키워드 가져오기
     */
    getHotKeyword = async()=>{
        try {
            const res = await mapApi.getHotKeyword();
            const HotKeywordList = res.data;
            this.setState({ HotKeywordList });
            return res.data;         
        } catch (error) {
            return undefined;
        }
        
    }

    render() {
        return (
            <HotKeywordLayout
                {...this.state}
                onChangeSearchHandler={this.props.onChangeSearchHandler}
            />
        )
    }
}
