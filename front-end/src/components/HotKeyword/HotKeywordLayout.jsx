import React from 'react'
import { Menu, Label } from 'semantic-ui-react'
import _ from 'lodash'

export default function HotKeywordLayout({ HotKeywordList, onChangeSearchHandler}) {
    //console.log(HotKeywordList);
    const content_list = _.map(HotKeywordList, 
        (item, index) => 
            <Menu.Item name='inbox' key={index} onClick={e => {
                let result = {
                    target: {
                        value: item.query
                    }
                }
                onChangeSearchHandler(result);
            }}>
                <Label color='teal' >{item.count}</Label>
                <p>
                {item.query}
                </p>
            </Menu.Item>
    )
    return (
        <Menu 
            style={{
                "display": (HotKeywordList.length > 0) ? 'block' : 'none'
            }}
            vertical 
            className="hot-keyword">
            {content_list}
        </Menu>
    )
}
HotKeywordLayout.defaultProps = {
    onChangeSearchHandler: () => console.warn("not define HotKeywordLayout"),
};
