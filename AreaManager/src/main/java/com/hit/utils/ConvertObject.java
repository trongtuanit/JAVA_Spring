package com.hit.utils;

import com.hit.dao.Province;
import com.hit.dto.ProvinceDTO;

public class ConvertObject {
	public static String slugify(String input) {
		return input.toLowerCase().replaceAll("[á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ|ä|å|æ|ą]", "a")
				.replaceAll("[ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ|ö|ô|œ|ø]", "o")
				.replaceAll("[é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ|ě|ė|ë|ę]", "e").replaceAll("[ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự]", "u")
				.replaceAll("[i|í|ì|ỉ|ĩ|ị|ï|î|į]", "i").replaceAll("[ù|ú|ü|û|ǘ|ů|ű|ū|ų]", "u")
				.replaceAll("[ß|ş|ś|š|ș]", "s").replaceAll("[ź|ž|ż]", "z").replaceAll("[ý|ỳ|ỷ|ỹ|ỵ|ÿ|ý]", "y")
				.replaceAll("[ǹ|ń|ň|ñ]", "n").replaceAll("[ç|ć|č]", "c").replaceAll("[ğ|ǵ]", "g")
				.replaceAll("[ŕ|ř]", "r").replaceAll("[·|/|_|,|:|;]", "-").replaceAll("[ť|ț]", "t").replaceAll("ḧ", "h")
				.replaceAll("ẍ", "x").replaceAll("ẃ", "w").replaceAll("ḿ", "m").replaceAll("ṕ", "p")
				.replaceAll("ł", "l").replaceAll("đ", "d").replaceAll("\\s+", "-").replaceAll("&", "-and-")
				.replaceAll("[^\\w\\-]+", "").replaceAll("\\-\\-+", "-").replaceAll("^-+", "").replaceAll("-+$", "");
	}
	
	
	public static Province provinceDtoToDao (ProvinceDTO provinceDTO) {
		
		Province province = new Province();
		province.setName(provinceDTO.getName());
		province.setSlug(slugify(provinceDTO.getName()));
		province.setType(provinceDTO.getType());
		if(provinceDTO.getType().compareToIgnoreCase("tinh")==0) {
			province.setNameWithType("Tỉnh " + province.getName());
			province.setType("tỉnh");
		}
		else {
			province.setNameWithType("Thành phố " + province.getName());
			province.setType("tỉnh");			
		}
		province.setCode(provinceDTO.getCode());
		return province;
		
	}
}
