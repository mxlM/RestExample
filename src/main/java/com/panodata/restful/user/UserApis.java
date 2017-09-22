package com.panodata.restful.user;

import com.panodata.conf.base.BaseController;
import com.panodata.conf.response.ResponseErrorEnum;
import com.panodata.conf.response.ResponseResult;
import com.panodata.conf.response.ResponseSuccessEnum;
import com.panodata.conf.response.RestResultGenerator;
import com.panodata.model.UserPO;
import com.panodata.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by wp_sp on 2017/9/21.
 */
@RestController
@RequestMapping("/api/UserPOs")
public class UserApis extends BaseController {

    @Autowired
    private UserService userService;


    /**
     * 查询全部用户列表
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseResult<List<UserPO>> all() {
        List<UserPO> all = userService.findAll();
        return RestResultGenerator.genResult(all, ResponseSuccessEnum.SUCCESS);
    }

    /**
     * 新增用户
     * @param UserPO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseResult<Boolean> save(@RequestBody UserPO UserPO) throws Exception {
        UserPO.setId(UUID.randomUUID().toString().replace("-",""));
        int i = userService.save(UserPO);
        return RestResultGenerator.genResult(i>0,ResponseSuccessEnum.SUCCESS);
    }

    /**
     * 根据条件查询
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/id/{id}/name/{name}", method = RequestMethod.GET)
    public ResponseResult<UserPO> get(@PathVariable String id,@PathVariable String name) throws Exception {
        UserPO UserPO = userService.findByIdAndName(id,name);
        if (null == UserPO){
            return RestResultGenerator.genErrorResult(ResponseErrorEnum.ERROR_A08);
        }
        return RestResultGenerator.genResult(UserPO,ResponseSuccessEnum.SUCCESS);
    }

    /**
     * 根据条件更新
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/id/{id}/name/{name}/tel/{tel}", method = RequestMethod.GET)
    public ResponseResult<Boolean> get(@PathVariable String id, @PathVariable String name, @PathVariable String tel) throws Exception {
        int i = userService.updateUserById(id,name,tel);
        return RestResultGenerator.genResult(i>0,ResponseSuccessEnum.SUCCESS);
    }



//    一般情况下，不会使用 put/delete  至于PATCH  更是遇不到
//    所以我们只使用上面的 get 和 post 就足够了

//    /**
//     * delete UserPO by id
//     * @param id UserPO id
//     * @return success
//     * @throws Exception
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseResult delete(@PathVariable Long id) throws Exception {
//        userService.delete(id);
//        return RestResultGenerator.genResult(null,ResponseSuccessEnum.SUCCESS);
//    }
//
//    /**
//     * update UserPO for all props
//     * @param id update UserPO id
//     * @param newUserPO new props
//     * @return updated UserPO
//     * @throws Exception
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseResult<UserPO> updateAll(@PathVariable String id, @Valid @RequestBody UserPO newUserPO) throws Exception {
//        UserPO UserPO = userService.findById(id);
//        // copy all new UserPO props to UserPO except id
//        BeanUtils.copyProperties(newUserPO, UserPO, "id");
//        UserPO = userService.save(UserPO);
//        return RestResultGenerator.genResult(UserPO,ResponseSuccessEnum.SUCCESS);
//    }
//
//    /**
//     * update UserPO for some props
//     * @param id update UserPO id
//     * @param newUserPO some props
//     * @return updated UserPO
//     * @throws Exception
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
//    public ResponseResult<UserPO> update(@PathVariable String id, @RequestBody UserPO newUserPO) throws Exception {
//        UserPO UserPO = userService.findById(id);
//        // copy all new UserPO props to UserPO except null props
//        BeanUtils.copyProperties(newUserPO, UserPO);
//        UserPO = userService.save(UserPO);
//        return RestResultGenerator.genResult(UserPO,ResponseSuccessEnum.SUCCESS);
//    }
}
