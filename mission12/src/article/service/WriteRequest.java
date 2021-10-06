package article.service;

import java.util.Map;

// 주소 등록 시 데이터(기본 주소, 상세 주소)가 필요한데,
// 이 데이터를 전달할 때 사용할 WriteRequest 클래스를 제작한다.
public class WriteRequest {

	// 주소 등록 시 필요한 기본주소, 상세주소 데이터를 정의한다.
	private String basicAddress; // 기본주소
	private String detailAddress; // 상세주소

	

	public WriteRequest(String basicAddress, String detailAddress) {
		this.basicAddress = basicAddress;
		this.detailAddress = detailAddress;
	}

	public String getBasicAddress() {
		return basicAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	// 데이터가 유효한지 여부를 검사한다.
	// 잘못된 데이터가 존재하면 errors 맵 객체에 관련 코드를 추가한다.
	public void validate(Map<String, Boolean> errors) {
		if (basicAddress == null || basicAddress.trim().isEmpty()) {
			errors.put("basic", Boolean.TRUE);
		}
	}
}
