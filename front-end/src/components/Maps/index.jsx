import React, { Component } from 'react'
import MapLayout from './MapLayout'
import * as mapApi from '../../services/maps'

export default class Maps extends Component {
    state = {
        searchData : null,
        page : 1,
        size : 12,
        searchResult : {},
        LatLng : {
            y: 33.450701,
            x: 126.570667,
            data:null,
        }
    }
    
    onChangeSearchHandler = (e)=>{        
        this.setState({ searchData: e.target.value })        
    }
    
    onSubmitSearchHandler = (e)=>{
        this.setState({ page: 1 })
        this.getLocalKeyword().then(searchResult => this.setState({ searchResult }));
        e.preventDefault();
    }

    setLatLng = ({ x , y , data })=>{
        this.setState({
            LatLng : {
                x, y, data
            }
        })
        //console.log(this.state.LatLng);
    }

    getLocalKeyword = async ()=>{
        try {
            const { searchData, page, size } = this.state;
            const res = await mapApi.getLocalKeyword({ 
                query: searchData , 
                page,size
            });
            //console.log(res.data);
            
            return res.data;
        } catch (error) {
            return undefined;
        }
    }

    onPrevButtonClickHandler = (e)=>{
        let { page, searchResult} = this.state;
        if (!searchResult.documents) return false;
        page = parseInt(page)
        
        if(page <= 1) return false;
        page = page - 1;

        this.setState({ page }, () => {
            this.getLocalKeyword().then(searchResult => this.setState({ searchResult }));
        })
    };
    onNextButtonClickHandler = (e)=>{
        let { page, searchResult } = this.state; 
        if (!searchResult.documents) return false;
        // let {  size,  } = this.state; 
        // page = parseInt(page) 
        // size = parseInt(size) 
        // let total_count = parseInt(searchResult.meta.total_count) 
        // let max_page = Math.abs(total_count / size) + 1;
        
        if (searchResult.meta.is_end ) return false;
        
        page = page + 1;
        this.setState({ page },()=>{ 
            this.getLocalKeyword().then(searchResult => this.setState({ searchResult }));
        })
        
    };


    render() {
        return (
            <MapLayout
                {...this.state}
                setLatLng={this.setLatLng}
                onChangeSearchHandler={this.onChangeSearchHandler}
                onSubmitSearchHandler={this.onSubmitSearchHandler}
                onPrevButtonClickHandler={this.onPrevButtonClickHandler}
                onNextButtonClickHandler={this.onNextButtonClickHandler}
            />
        )
    }
}
