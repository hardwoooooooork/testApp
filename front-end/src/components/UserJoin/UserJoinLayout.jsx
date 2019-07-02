import React from 'react'
import { Button, Header, Icon, Modal, Form } from 'semantic-ui-react'


export default function UserJoinLayout(prop) {
    
    return (
        <Modal
            trigger={<span onClick={prop.handleOpen} style={{ "color": "blue", "marginRight": "7px", "cursor": "pointer" }}>Sign Up</span>}
            open={prop.modalOpen}
            onClose={prop.handleClose}
            size='small'
        >
            <Header icon='browser' content='User Join' />
            <Modal.Content>
                <Form>
                    <Form.Field>
                        <label>ID</label>
                        <input type="text" name="userId" placeholder='User id' onChange={prop.onChangeHandler} value={(prop.formData.userId) ? prop.formData.userId: ''} />
                    </Form.Field>
                    <Form.Field>
                        <label>Name</label>
                        <input type="text" name="userName" placeholder='User Name' onChange={prop.onChangeHandler} value={(prop.formData.userName) ? prop.formData.userName: ''} />
                    </Form.Field>
                    <Form.Field>
                        <label>Password</label>
                        <input type="password" name="userPassword" placeholder='User Password' onChange={prop.onChangeHandler} value={(prop.formData.userPassword) ? prop.formData.userPassword: ''} />
                    </Form.Field>
                </Form>
            </Modal.Content>
            <Modal.Actions>
                <Button color='green' type='button' inverted onClick={prop.onsubmitHandler}>
                    <Icon name='checkmark' /> Submit</Button>
                <Button color='red' onClick={prop.handleClose} inverted>
                    <Icon name='x' /> Close
          </Button>
            </Modal.Actions>
        </Modal>
    )
}
