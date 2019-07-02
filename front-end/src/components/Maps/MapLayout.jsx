import React from 'react'
import { Container, Grid, Header, Menu, Input, Label, List, Button, Icon} from 'semantic-ui-react'
import './Maps.css'
import KakaoMap from './KakaoMap'
export default function MapLayout() {
    return (
        <div>
            <Container id="Maps">
                <div className="title">
                    <Header as='h2'>Map List</Header>
                    <Button>Logout</Button>
                </div>
                
                <Grid className="container">
                    <Grid.Column width={4} className="map-find-area">
                        <Menu vertical className="map-find-menu">
                            <Menu.Item className="find-input">
                                <form>
                                    <Input icon={<Icon name='search' inverted circular link />} placehold="Search ....." />
                                </form>
                            </Menu.Item>
                            <Menu.Item className="find-result-area">
                                <List>
                                    <List.Item>a</List.Item>
                                    <List.Item>b</List.Item>
                                    <List.Item>c</List.Item>
                                    <List.Item>d</List.Item>
                                    <List.Item>e</List.Item>
                                    <List.Item>f</List.Item>
                                    <List.Item>g</List.Item>
                                    <List.Item>h</List.Item>
                                    <List.Item>i</List.Item>
                                    <List.Item>j</List.Item>
                                    <List.Item>k</List.Item>
                                </List>
                            </Menu.Item>
                            <Menu.Item className="find-padding"> 
                                <Menu pagination>
                                    <Menu.Item name='1' />
                                    <Menu.Item disabled>...</Menu.Item>
                                    <Menu.Item name='12' />
                                </Menu>
                            </Menu.Item>
                        </Menu>                  
                    </Grid.Column>
                    <Grid.Column width={12} className="map-view-area">
                        <KakaoMap/>
                    </Grid.Column>
                    <div className="hot-keyword-area">
                        <Menu vertical className="hot-keyword">
                            <Menu.Item name='inbox'>
                                <Label color='teal'>1</Label>
                                Inbox
                            </Menu.Item>
                            <Menu.Item name='spam'>
                                <Label>51</Label>
                                Spam
                            </Menu.Item>
                            <Menu.Item name='updates'>
                                <Label>1</Label>
                                Updates
                            </Menu.Item>
                        </Menu>
                    </div>
                </Grid>
            </Container>
        </div>
    )
}
