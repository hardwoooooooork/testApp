package com.jeaeok.myproject.testApp.models;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoryGroupCode implements AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		Integer result = null;
		if(attribute == null) return null;
		switch (attribute) {
			case "MT1": result = 1; break;	//대형마트
			case "CS2": result = 2; break;	//편의점
			case "PS3": result = 3; break;	//어린이집, 유치원
			case "SC4": result = 4; break;	//학교
			case "AC5": result = 5; break;	//학원
			case "PK6": result = 6; break;	//주차장
			case "OL7": result = 7; break;	//주유소, 충전소
			case "SW8": result = 8; break;	//지하철역
			case "BK9": result = 9; break;	//은행
			case "CT1": result = 10; break;	//문화시설
			case "AG2": result = 11; break;	//중개업소
			case "PO3": result = 12; break;	//공공기관
			case "AT4": result = 13; break;	//관광명소
			case "AD5": result = 14; break;	//숙박
			case "FD6": result = 15; break;	//음식점
			case "CE7": result = 16; break;	//카페
			case "HP8": result = 17; break;	//병원
			case "PM9": result = 18; break;	//약국
		default:
			break;
		}
		return result;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		String result = null;
		if(dbData == null) return null;
		switch (dbData) {
		case 1 : result = "MT1"; break;	//대형마트
		case 2 : result = "CS2"; break;	//편의점
		case 3 : result = "PS3"; break;	//어린이집, 유치원
		case 4 : result = "SC4"; break;	//학교
		case 5 : result = "AC5"; break;	//학원
		case 6 : result = "PK6"; break;	//주차장
		case 7 : result = "OL7"; break;	//주유소, 충전소
		case 8 : result = "SW8"; break;	//지하철역
		case 9 : result = "BK9"; break;	//은행
		case 10: result = "CT1"; break;	//문화시설
		case 11: result = "AG2"; break;	//중개업소
		case 12: result = "PO3"; break;	//공공기관
		case 13: result = "AT4"; break;	//관광명소
		case 14: result = "AD5"; break;	//숙박
		case 15: result = "FD6"; break;	//음식점
		case 16: result = "CE7"; break;	//카페
		case 17: result = "HP8"; break;	//병원
		case 18: result = "PM9"; break;	//약국
		default:
			break;
		}
		return result;
	}

}
