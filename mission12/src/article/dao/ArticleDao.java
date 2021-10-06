package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import article.model.Article;
import jdbc.JdbcUtil;

// article 테이블과 article_content 테이블에 데이터를 추가할 때
// 사용할 ArticleDao 클래스와 ArticleContentDao 클래스를 구현한다.
public class ArticleDao {

	// 1. 주소 등록
	public Article insert(Connection conn, Article article) throws SQLException {

		PreparedStatement pstmt = null;

		try {
			// insert 쿼리를 실행해서 article 테이블에 데이터를 삽입한다.
			// article_no 칼럼은 자동 증가 칼럼이르모
			// insert 쿼리를 실행할 때 값을 지정하지 않는다.
			pstmt = conn.prepareStatement(
					"insert into jsp_address(address_id, basic_address, detail_address) values(idx_seq.nextval, ?, ?)");

			pstmt.setString(1, article.getBasicAddress());
			pstmt.setString(2, article.getDetailAddress());
			pstmt.executeUpdate();

			return new Article(article.getBasicAddress(), article.getDetailAddress());

		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}
