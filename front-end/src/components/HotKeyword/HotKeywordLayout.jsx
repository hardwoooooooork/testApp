import React from 'react'
import { Menu, Label } from 'semantic-ui-react'
import _ from 'lodash'

export default function HotKeywordLayout({ HotKeywordList}) {
    //console.log(HotKeywordList);
    const content_list = _.map(HotKeywordList, 
        (item, index) => 
            <Menu.Item name='inbox' key={index}>
                <Label color='teal' >{item.count}</Label>
                {item.query}
            </Menu.Item>
    )
    return (
        <Menu vertical className="hot-keyword">
            {content_list}
        </Menu>
    )
}
