import React from 'react'
import './Login.css'
import { Button, Form, Grid, Header, Image, Message, Segment } from 'semantic-ui-react'
import kakao from './kakao.png';
import UserJoin from '../UserJoin'

export default function LoginLayout(props) {
    const {formData} = props;
    return (
        <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
            <Grid.Column style={{ maxWidth: 450 }}>
                <Header as='h2' color='teal' textAlign='center'>
                    <Image src={kakao} /> Log-in to your account
                </Header>
                <Form size='large' onSubmit={props.onSubmitHandler}>
                    <Segment stacked>
                        <Form.Input 
                            fluid 
                            icon='user' 
                            iconPosition='left' 
                            name="username"
                            placeholder='ID' 
                            onChange={props.onChangeHandler}
                            value={formData.username ? formData.username : ''}
                            required
                        />
                        <Form.Input
                            fluid
                            icon='lock'
                            iconPosition='left'
                            name="password"
                            placeholder='Password'
                            type='password'
                            onChange={props.onChangeHandler}
                            value={formData.password ? formData.password : ''}
                            required
                        />
                        <Button color='teal' fluid size='large'>
                            Login
                        </Button>
                    </Segment>
                </Form>
                <Message>
                    New to us? <UserJoin/>
                </Message>
            </Grid.Column>
        </Grid>
    );
}
