package com.bank.web.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
   // 필드
   private MemberVO member;
   private MemberVO[] memberList;
   private Map<String, MemberVO> map;   // Map은 인터페이스
   
   @Autowired 
   private SqlSession sqlSession;   
   
   public MemberServiceImpl(){
      map = new HashMap<String, MemberVO>();
   }

   public MemberVO[] getMemberList() {
      return memberList;
   }

   public void setMemberList(MemberVO[] memberList) {
      this.memberList = memberList;
   }

   @Override
   public MemberVO login(MemberVO member) {
      // 로그인
      MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
      member = mapper.selectMember(member);

      return member;
   }

   @Override
   public String update(MemberVO member) {
      // 정보수정
      map.replace(member.getUserid(), member);
      return "업데이트 성공";
   }
   
   @Override
   public String join(MemberVO member) {
      // 회원가입
      map.put(member.getUserid(), member);
      return member.getName() + "회원 가입을 축하드립니다.";
   }

   @Override
   public MemberVO searchById(String id) {
      // 아이디로 회원정보 검색
      return  map.get(id);
   }

   @Override
   public MemberVO[] searchByName(String name) {
      // 이름으로 회원정보 검색
      MemberVO[] tempList = new MemberVO[this.searchCountByName(name)];
      int j = 0;

      for (int i = 0; i < map.size(); i++) {
         if (map.get(i).getName().equals(name)) {
            tempList[j] = map.get(i);
            j++;
         }
      }
      return tempList;
   }

   @Override
   public String remove(String userid) {
      // 회원 탈퇴
      
      /*MemberBean tempMember = null;
      String result = "";
      
      if(this.searchById(userid) != null){
         for (int i = 0; i < this.getCount(); i++) {            
            if (memberList[i].getUserid().equals(userid)) {
               tempMember = memberList[i];
               memberList[i] = memberList[this.getCount()-1];
               memberList[this.getCount()-1] = null;
            }         
         }   
         this.setCount(this.getCount()-1);
         result = tempMember.getUserid() + "삭제 성공";
      }else
         result = "해당 아이디가 없음";
         
      return result;*/

      return (map.remove(userid) != null)? "탈퇴 성공":"탈퇴 실패";
   }

   @Override
   public int countAll() {
      // 전체 회원 수 조회
      return map.size();
   }

   @Override
   public int searchCountByName(String name) {
      // 이름으로 가입된 아이디 검색
      int tempCount = 0;

      for (int i = 0; i < map.size(); i++) {
         if (memberList[i].getName().equals(name)) {
            tempCount++;
         }
      }

      return tempCount;
   }

}