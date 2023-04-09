package com.example.begin.controller;

import com.example.begin.dto.Req;
import com.example.begin.dto.Res;
import com.example.begin.dto.UserDto;
import com.example.begin.naverAPI.dto.ImageSearchReqDTO;
import com.example.begin.naverAPI.dto.LocalSearchReqDTO;
import com.example.begin.service.NaverService;
import com.example.begin.service.ReviewService;
import com.example.begin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/apis")
@RestController
public class ApiController {

    private final NaverService naverService ;
    private final UserService userService;
    private final ReviewService reviewService;
    @GetMapping(value = "/search/local")
    public ResponseEntity findLocalSearch(@RequestParam("query") String query){
        var reqDTO = LocalSearchReqDTO.builder().query(query).build();

        return ResponseEntity.status(HttpStatus.OK).body(naverService.findLocalSearch(reqDTO));
    }

    @GetMapping(value = "/search/image")
    public ResponseEntity findImageSearch(@RequestParam("query") String query){
        var reqDTO = ImageSearchReqDTO.builder().query(query).build();

        return ResponseEntity.status(HttpStatus.OK).body(naverService.findImageSearch(reqDTO));
    }

    @GetMapping(value = "/search")
    public ResponseEntity findSearch(@RequestParam("query") String query){

        return ResponseEntity.status(HttpStatus.OK).body(naverService.search(query));
    }

    @GetMapping(value = "/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String userName){
        return userName;
    }

    //pathVariable로 name을 받고 queryParm으로 id를 받는 get method 작성
    @GetMapping(value = "path-var/{name}")
    public String pathVar(@PathVariable(name = "name") String userName, @RequestParam String id){
        return "userName : " + userName + "   id : "+id;
    }

    @GetMapping(value = "/mapParam")
    Map<String,String> mapParam(@RequestParam Map<String,String> queries){
        return queries;
    }

    @GetMapping(value = "/objectParam")
    Req mapParam(Req queries){
        return queries;
    }

    @PostMapping(value = "/post")
    public void post(@RequestBody Map<String,Object> reqData){
        reqData.entrySet().forEach(e->{
            log.info("key = {}, value = {}",e.getKey(), e.getValue() );
        });
    }

    @PutMapping(value = "/put/{userid}")
    public ResponseEntity put(@RequestBody Req req){
        log.info("Req : {}",req);
        var res = Res.builder().httpSatus(HttpStatus.OK.toString())
                .result("OK")
                .idx(1L)
                .name(req.getName())
                .build();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/user-info")
    public ResponseEntity findUserInfo(@RequestParam String userid) {
        log.info("user id = {}", userid);
        var dto = userService.findUserInfo(userid);
        if(dto.getIdx() != null) {
            dto.setResult("OK");
            return ResponseEntity.ok(dto);
        }
        dto.setResult("FAIL");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @PostMapping("/adduser")
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        log.info("user = {}", userDto.toString());
        var dto = userService.registerUser(userDto);
        if(dto.getIdx() != null) {
            dto.setResult("OK");
            return ResponseEntity.ok(dto);
        }
        dto.setResult("FAIL");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @GetMapping(value = "/{userid}/reviews")
    public ResponseEntity findReviews(@PathVariable(value = "userid") String userId){
       var reviews = reviewService.findReviews(userId);

       return ResponseEntity.ok(reviews);
    }
}
