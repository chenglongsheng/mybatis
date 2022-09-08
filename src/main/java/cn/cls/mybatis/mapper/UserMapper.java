package cn.cls.mybatis.mapper;

import cn.cls.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 添加用户信息
     *
     * @param user
     * @return useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
     * 数user对象的某个属性中
     */
    int insertUser(User user);

    int deleteUser();

    int updateUser();

    User getUserById(@Param("id") int id);

    List<User> getUserList();

    /**
     * 查询用户的总记录数
     *
     * @return 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    int getCount();

    /**
     * 查询所有用户信息为map集合
     *
     * @return 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
     * 此时可以将这些map放在一个list集合中获取
     */
//    List<Map<String, Object>> getAllUserToMap();

    /**
     * 查询所有用户信息为map集合
     *
     * @return 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
     */
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    /**
     * 测试模糊查询
     *
     * @param param
     * @return
     */
    List<User> testLike(@Param("param") String param);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);

}
