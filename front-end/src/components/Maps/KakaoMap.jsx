import React, { Component , createRef} from 'react'
import $script from 'scriptjs';

export default class KakaoMap extends Component {
    constructor(props){
        super(props);
        this.appRef = createRef();
    }
    componentDidMount() {
        const API_KEY = ""
        const kakao_url = `http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${API_KEY}`;
        var that = this;
        $script(kakao_url, () => {
            //console.log();
            // golobal setting
            /*global kakao*/            
            kakao.maps.load(function () {
                // v3가 모두 로드된 후, 이 콜백 함수가 실행됩니다.
                var map = new kakao.maps.Map(that.appRef.current, { 
                    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                });
                var marker = new kakao.maps.Marker({
                    position: new kakao.maps.LatLng(33.450701, 126.570667),
                });
                marker.setMap(map);
            });
            
        })
    }
    render() {
        return (
            <div style={{'height':'850px'}} ref={this.appRef}>
                
            </div>
        )
    }
}
