import React, { memo } from 'react';
import {FooterWrapper, FooterTop, FooterBody, FooterBottom} from './styles/Footer.styles';
import { FaFacebook, FaYoutube, FaInstagram, FaTwitter } from 'react-icons/fa';

const Footer: React.FC = () => {

    return (
        <FooterWrapper>
            <FooterTop>
                <ul className="firstRow">
                <li>매장안내</li>
                <li>나이키 저널</li>
                <li>로그인</li>
                <li>멤버 가입</li>
                </ul>
                <ul className="secondRow">
                <li className="rowTitle">고객 센터</li>
                <li>080-111-2233</li>
                <li>주문/결제</li>
                <li>배송</li>
                <li>주문배송조회</li>
                <li>멤버쉽 혜택/서비스</li>
                <li>공지사항</li>
                <li>1:1 채팅 문의</li>
                <li>1:1 이메일 문의</li>
                <li>이용약관</li>
                <li>개인정보처리방침</li>
                </ul>
                <ul className="thirdRow">
                <li className="rowTitle">ABOUT NIKE</li>
                <li>나이키에 대하여</li>
                </ul>
                <div className="forthRow">
                <div className="rowTitle">SOCIAL</div>
                <FaFacebook className="icon" />
                <FaInstagram className="icon" />
                <FaTwitter className="icon" />
                <FaYoutube className="icon" />
                </div>
                <div className="mobileRow">
                <div>주문배송</div>
                <div>매장안내</div>
                <div>고객센터</div>
                </div>
            </FooterTop>
            <FooterBody>
                <div className="bodyWrapper">
                <div className="left">대한민국</div>
                <div>2022 Nike, inc.</div>
                </div>
                <div className="bodyWrapper">
                <div>이용약관</div>
                <div className="right">개인정보처리방침</div>
                </div>
            </FooterBody>
            <FooterBottom>
                <div className="footerWrapper">
                <div className="firstRow">
                    (유)나이키코리아 대표 Jamie Lee | 서울 강남구 테헤란로 152 강남 파이낸스센터 30층
                </div>
                <div className="secondRow">
                    통신판매업신고번호 2022-서울강남-12345 | 등록번호 111-22-334455
                    <span>사업자정보확인</span>
                </div>
                <div className="thirdRow">
                    고객센터 전화문의
                    <span>080-111-2233</span>
                </div>
                <div className="endRow">
                    FAX 051-9997-7777 | E-mail service@nike.co.kr | 호스팅서비스사업자 (유)나이키코리아
                </div>
                </div>
                <div className="footerWrapper">
                <div className="firstRow">안전거래를 위해 현금 등으로 결제 시 저희 쇼핑몰에서 가입한</div>
                <div>KG이니시스의 구매안전서비스 (채무지급보증)를 이용하실 수 있습니다.</div>
                <br />
                <div className="endRow">
                    온라인디지털콘텐츠사업발전법에 의한<span>콘텐츠보호안내 자세히보기</span>
                </div>
                </div>
            </FooterBottom>
        </FooterWrapper>
    );
  };

export default memo(Footer);
