package NewJeans.FanCm.controller;

import NewJeans.FanCm.domain.Member;
import NewJeans.FanCm.dto.MemberDto;
import NewJeans.FanCm.exception.ApiResponse;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import NewJeans.FanCm.service.MemberService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor

public class member {
    private final MemberService memberService;
    //회원가입
    @PostMapping("/member/join")
    @ResponseBody
    public ResponseEntity<?> memberJoin(@RequestBody @Valid CreateUserRequest request){

        Member member = new Member();
        member.setNickName(request.getNickName());
        member.setId(request.getId());
        member.setPassword(request.getPassword());
        member.setMobile1(request.getMobile1());
        member.setMobile2(request.getMobile2());
        member.setMobile3(request.getMobile3());
        member.setEmail1(request.getEmail1());
        member.setEmail2(request.getEmail2());
        member.setRegDate(LocalDateTime.now());

        Member join = memberService.join(member);
        MemberDto dto = new MemberDto(join.getId(), join.getNickName());

        return ResponseEntity.ok(new ApiResponse(200, "회원가입 성공", dto));
    }

    @Data
    static class CreateUserRequest {
        private String nickName;
        private String id;
        private String password;
        private String mobile1;
        private String mobile2;
        private String mobile3;
        private String email1;
        private String email2;
    }
}
