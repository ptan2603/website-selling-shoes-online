import { Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import React, { useState , useEffect } from "react";
import Footer from "../common/Footer";
import Header from "../common/Header";
import Home from "../components/Home";
import Cart from "../components/Cart";
import Contact from "../components/Contact";
import Product from "../components/Product";
import ProductDetail from "../components/ProductDetail";
import Search from "../components/Search";
import SignIn from "../account/SignIn";
import Register from "../account/Register";
import ForgotPassword from "../account/ForgotPassword";
import { Container } from "react-bootstrap";
import "../App.css";
import 'react-toastify/dist/ReactToastify.css';
import Checkout from "../components/Checkout";

const UserLayOut = () => {
  const [temp, setTemp] = useState(true);
  const [buy, setBuy] = useState([]);
  const [header, setHeader] = useState(1);
  const [outStock, setOutStock] = useState([]);
  const [cartItem, setCartItem] = useState([]);
  const [keyword, setKeyword] = useState("");

  useEffect(() => {
    setCartItem([]);
    setBuy([]);
  }, [temp]);

  const outStockHandler = (data) => {
    setOutStock(data);
  };

  const addHandler = (data) => {
    const res = cartItem.find((item) => item.id === data.id);
    if (res) {
      setCartItem(
        cartItem.map((item) =>
          item.id === data.id
            ? { ...res, quantity: res.quantity + data.quantity }
            : item
        )
      );
    } else {
      setCartItem([...cartItem, data]);
    }
  };

  const clearHandler = () => {
    const res = cartItem.filter((item) => !buy.includes(item.id + ""));
    setCartItem(res);
  };
  
  const buyHandler = (id) => {
    setBuy([...buy, id]);
  };

  const cancelBuyHandler = (id) => {
    const res = buy.filter((item) => item !== id);
    setBuy(res);
  };

  const searchHandler = (keyword) => {
    setKeyword(keyword);
  };

  const cartHandler = (data) => {
    setCartItem(data);
  };

  const setCartItemHandler = (data) => {
    setCartItem(data);
  };

  const refresh = (data) => {
    setTemp(data);
  };

  return (
    <div className="app-container">
      <Container>
        <Header
        header={header}
        searchHandler={searchHandler}
      ></Header>
        
          <Routes>
            <Route path="/" element={<Home/>} />

            <Route path="/sanpham" element={<Product/>} />

            <Route path={`/product-detail/:id`} element={<ProductDetail 
              addHandler={addHandler} />} />

            <Route path="/giohang" element={<Cart 
              outStockHandler={outStockHandler}
              buyHandler={buyHandler}
              cancelBuyHandler={cancelBuyHandler}
              buy={buy}
              cartItem={cartItem}
              cartHandler={cartHandler}/>} />

            <Route path="/muahang" element={<Checkout
              temp={temp}
              buy={buy}
              outStockHandler={outStockHandler}
              cartItem={cartItem}
              clearHandler={clearHandler}
              setCartItemHandler={setCartItemHandler}/>} />

            <Route path="/search" element={<Search
              keyword={keyword}/>} />

            <Route path="/lienhe" element={<Contact/>} />

            <Route path="/dangnhap" element={<SignIn/>} />

            <Route path="/dangky" element={<Register/>} />

            <Route path="/quenmatkhau" element={<ForgotPassword/>} />
          </Routes>

        <Footer />

        <ToastContainer
          position="top-center"
          autoClose={5000}
          hideProgressBar={false}
          newestOnTop={false}
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
          theme="light"
        />
      </Container>
    </div>
  );
};

export default UserLayOut;
