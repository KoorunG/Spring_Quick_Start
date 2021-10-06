package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

// 게시글 쓰기 기능을 제공할 WriteArticleService 클래스를 제작한다.
public class WriteArticleService {

	private ArticleDao articleDao = new ArticleDao();

	// write() 메서드는 WriteRequest 타입의 req 파라미터(매개변수)를 이용해서
	// 게시글을 등록하고, 결과로 게시글 번호를 리턴한다.
	public void write(WriteRequest req) {

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			// 트랜잭션 처리를 위한 자동 커밋 false 처리
			conn.setAutoCommit(false);

			// WriteRequest로부터 Article 객체를 생성한다.
			Article article = toArticle(conn, req);

			// ArticleDao의 insert() 메서드를 실행하고,
			// 그 결과를 savedArticle에 할당한다.
			Article savedArticle = articleDao.insert(conn, article);

			// savedArticle이 null이면
			// article 테이블에 삽입한 레코드가 없기에
			// RuntimeException 예외 처리를 수행한다.
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article 입력 실패");
			}

			// 트랜잭션을 커밋 처리한다.
			conn.commit();

			// 앞서 트랜잭션 처리 과정에서 예외 처리가 발생할 경우
			// 트랜잭션 처리를 중단하고 롤백 처리를 한다.
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Article toArticle(Connection conn, WriteRequest req) throws SQLException {
		return new Article(req.getBasicAddress(), req.getDetailAddress());
	}
}
