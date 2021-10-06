package article.model;

public class Article {

	private String basicAddress; // article 테이블의 basic 필드(칼럼)와 연관됨
	private String detailAddress; // article 테이블의 detail 필드(칼럼)와 연관됨

	public Article(String basicAddress, String detailAddress) {
		this.basicAddress = basicAddress;
		this.detailAddress = detailAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public String getBasicAddress() {
		return basicAddress;
	}
}
