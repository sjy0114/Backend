package NewJeans.FanCm.service;

import NewJeans.FanCm.domain.Member;
import NewJeans.FanCm.exception.ExceptionResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import NewJeans.FanCm.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public Member join(Member member) {
        validateDuplicateUser(member);
        memberRepository.save(member);
        return member;
    }

    //user_id 중복 체크
    private void validateDuplicateUser(Member member) {
        List<Member> findMembersById = memberRepository.findByID(member.getId());
        if(!findMembersById.isEmpty()){
            throw new ExceptionResponse(409,"id 중복", "ID_DUPLICATION");
        }

        List<Member> findMemberByNickname = memberRepository.findByNickname(member.getNickName());
        if(!findMemberByNickname.isEmpty()){
            throw new ExceptionResponse(409,"nickname 중복", "NICKNAME_DUPLICATION");
        }
    }

}
