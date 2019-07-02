import React from 'react'
import { Container, Grid, Header, Menu, Input, List, Button, Icon, Popup, Table} from 'semantic-ui-react'
import _ from 'lodash'
import HotKeyword from '../HotKeyword';
import './Maps.css'
import KakaoMap from './KakaoMap'

import History from '../History'

export default function MapLayout(props) {
    //console.log(props);
    const { searchResult } = props;
    const search_list = searchResult.documents && searchResult.documents.length > 0 ?
        _.map(searchResult.documents
            , (item, index) => 
                <List.Item key={index}>
                    <Popup
                        flowing
                        hoverable
                        trigger={<List.Icon name='marker' />}
                    >
                        <div>
                            <Table>
                                <Table.Body>
                                    <Table.Row>
                                        <Table.Cell>
                                            이름
                                    </Table.Cell>
                                        <Table.Cell>
                                            {item.place_name}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            주소
                                </Table.Cell>
                                        <Table.Cell>
                                            {item.road_address_name}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            전화번호
                                </Table.Cell>
                                        <Table.Cell>
                                            {item.phone}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            장소 바로가기
                                </Table.Cell>
                                        <Table.Cell>
                                            <a href={`https://map.kakao.com/link/map/${item.place_name},${item.y},${item.x}`} target="_blank" rel="noopener noreferrer">
                                                장소 가로가기
                                    </a>
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            홈페이지
                                </Table.Cell>
                                        <Table.Cell>
                                            <a href={item.place_url} target="_blank" rel="noopener noreferrer" >
                                                {item.place_url}
                                            </a>
                                        </Table.Cell>
                                    </Table.Row>
                                </Table.Body>
                            </Table>
                        </div>
                    </Popup>
                    
                    <List.Content>
                        <List.Header as='a' onClick={e => props.setLatLng( { x : item.x, y : item.y, data : item } )}>
                            {item.place_name}
                        </List.Header>
                        <List.Description>
                            {item.road_address_name}
                        </List.Description>
                    </List.Content>
                    
                </List.Item>
            )
        : <List.Item>no data</List.Item>


    return (
        <div>
            <Container id="Maps">
                <div className="title">
                    <Header as='h2'>Map List</Header>
                    <Button
                        onClick={e => {
                            localStorage.clear();
                            window.location.href = '/';
                        }}
                    >
                        Logout
                    </Button>
                </div>
                
                <Grid className="container">
                    <Grid.Column width={4} className="map-find-area">
                        <Menu vertical className="map-find-menu">
                            <Menu.Item className="find-input">
                                <Popup
                                    trigger={
                                        <Input
                                            icon={<Icon name='search' inverted circular link onClick={props.onSubmitSearchHandler} />}
                                            placehold="Search ....."
                                            onChange={props.onChangeSearchHandler}
                                            value={(props.searchData) ? props.searchData : ''}
                                            required
                                        />
                                    }    
                                    on='focus'
                                >
                                    <History/>
                                </Popup>
                                    
                            </Menu.Item>
                            <Menu.Item className="find-result-area">
                                <List>
                                    {search_list}
                                    {/* <List.Item>a</List.Item>
                                    <List.Item>b</List.Item>
                                    <List.Item>c</List.Item>
                                    <List.Item>d</List.Item>
                                    <List.Item>e</List.Item>
                                    <List.Item>f</List.Item>
                                    <List.Item>g</List.Item>
                                    <List.Item>h</List.Item>
                                    <List.Item>i</List.Item>
                                    <List.Item>j</List.Item>
                                    <List.Item>k</List.Item> */}
                                </List>
                            </Menu.Item>
                            {
                                searchResult.documents && searchResult.documents.length > 0 ?
                                    <Menu.Item className="find-padding">

                                        <Input type='text' placeholder='' action>
                                            <Button icon="angle left" className="btn-pre" onClick={props.onPrevButtonClickHandler} />
                                            <input
                                                placeholder=""
                                                className="pagination-input"
                                                readOnly
                                                value={(searchResult.documents) ? props.page : ''}
                                            />
                                            <Button icon="angle right" className="btn-next" onClick={props.onNextButtonClickHandler} />
                                        </Input>
                                    </Menu.Item>
                                    : null
                            }
                            
                        </Menu>                  
                    </Grid.Column>
                    <Grid.Column width={12} className="map-view-area">
                        <KakaoMap
                            LatLng={props.LatLng}
                        />
                    </Grid.Column>
                    <div className="hot-keyword-area">
                        <HotKeyword
                            
                        />
                    </div>
                </Grid>
            </Container>
        </div>
    )
}
