package com.example.pracprj2back.mapper;

import com.example.pracprj2back.domain.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member (id, password, email)
            VALUES (#{id}, #{password}, #{email})
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
            SELECT id, password, email, inserted
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
}