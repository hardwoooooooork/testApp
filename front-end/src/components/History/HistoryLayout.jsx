import React from 'react'
import './History.css'
import ReactTable from 'react-table'
import 'react-table/react-table.css'

export default function HistoryLayout({ historyData, onChangeSearchHandler }) {
    const data = historyData;

    const columns = [{
        Header: 'Keyword',
        width: '300px',
        accessor: 'query' ,
        Cell: props =>
            <p onClick={e => {
                let result = {
                    target : {
                        value: props.value
                    }
                }
                onChangeSearchHandler(result);
            } }>
                {props.value}
            </p>
    }, {
        Header: 'Date',
        width: '600px',
        accessor: 'createdTime',
        Cell: props => 
            <span className='number'>
                {(props.value).replace('T', " ") }
            </span> // Custom cell components!

    },]

     
    return (
        <div id="History">
            <ReactTable
                minRows={5}
                defaultPageSize={5}
                data={data}
                columns={columns}
            />
        </div>
    )
}
