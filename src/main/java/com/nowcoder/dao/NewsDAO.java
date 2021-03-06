package com.nowcoder.dao;

import com.nowcoder.model.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface NewsDAO {

        String TABLE_NAME = "news";
        String INSERT_FIELDS = "title , link , image  , like_count,comment_count,created_date,user_id ,content";
        String SELECT_FIELDS =" id , "+ INSERT_FIELDS;

        @Insert({"insert into ",TABLE_NAME," (",INSERT_FIELDS,
                ") values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId},#{content})"})
        int addNews(News news);

        List<News> selectByUserId(@Param("userId") int userId);

        @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME})
        List<News> selectAllNews();

        @Update({"update ",TABLE_NAME," set comment_count = #{commentCount} where id = #{id}"})
        int updateCommentCount(@Param("id") int id ,@Param("commentCount") int commentCount);

     /*   @Update({"update ",TABLE_NAME, " set comment_count = #{commentCount} where id = #{id}"})
        int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);*/

        @Select({"select ",SELECT_FIELDS,"from ",TABLE_NAME," where id = #{id}"})
        News selectById(int id );

        @Update({"update ",TABLE_NAME," set like_count = #{likeCount} where id = #{newsId}"})
         void updateLikeCount(@Param("newsId") int newsId, @Param("likeCount") int likeCont);
}
