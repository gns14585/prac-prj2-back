package com.example.pracprj2back.mapper;

import com.example.pracprj2back.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member (id, password, nickName, email)
            VALUES (#{id}, #{password},#{nickName}, #{email})
            """)
    int insert(Member member);

    @Select("""
            SELECT id 
            FROM member
            WHERE id = #{id}
            """)
    String selectId(String id);

    @Select("""
            SELECT email
            FROM member
            WHERE email = #{email}
            """)
    String selectEmail(String email);

    @Select("""
            SELECT id, password, nickName, email, inserted
            FROM member
            ORDER BY inserted DESC
            """)
    List<Member> selectAll();

    @Select("""
            SELECT *
            FROM member
            WHERE id = #{id}
            """)
    Member selectById(String id);

    @Delete("""
            DELETE FROM member
            WHERE id = #{id}
            """)
    int deleteById(String id);

    // 수정버튼을 눌렀을때 password가 그대로인 상태라면 빈칸으로 두고 수정버튼을 누르는데
    // if문이 없으면 패스워드는 빈칸으로 바뀌게됨
    // 그래서 if문 안에 있는 코드는 password가 변경되고싶지 않을때에 대비한 코드
    @Update("""
            <script>
            UPDATE member
            SET 
                <if test="password != ''">
                password = #{password},
                </if>
                nickName = #{nickName},
                email = #{email}
            WHERE id = #{id}
            </script>
            """)
    int update(Member member);

    @Select("""
            SELECT nickName
            FROM member
            WHERE nickName = #{nickName}
            """)
    String selectNickName(String nickName);
}
