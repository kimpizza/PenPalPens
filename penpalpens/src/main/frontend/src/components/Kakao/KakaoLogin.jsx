import React from "react";
import styled from "styled-components";

const KaKaoLogin = () => {

    const REST_API = process.env.REACT_APP_KAKAO_RESTAPI_KEY;

    const RE_DIRECT = process.env.REACT_APP_KAKAO_REDIRECT_URI;

    const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API}&redirect_uri=${RE_DIRECT}&response_type=code`;

    const handleLogin = () => {
        window.location.href = KAKAO_AUTH_URL
    }

    return (
        <>
            <LoginButton onClick={handleLogin}>카카오 로그인</LoginButton>
        </>
    );
}

export default KaKaoLogin;

const LoginButton = styled.div`
    width: 50%;
    height: 9rem;
    border: 5px solid #fdf6e4;
    color: #fdf6e4;
    font-size: 2rem;
    margin: 0 auto;
    margin-top: 5rem;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 1rem;
    background-color: black;
    cursor: pointer;
`