import jdbc工具包.JdbcUtil;
import 用户类.question;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class questionDao {
    JdbcUtil util = new JdbcUtil();
//    考试添加
    public int add(question question){
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer)values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
