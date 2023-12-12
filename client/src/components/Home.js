
import "../App.css";

import { useEffect, useState } from "react";

import Carousel from "react-bootstrap/Carousel";
import { getAllProducts } from "../api/ProductApi";
import image1 from "../static/image/image1.jpg";
import image2 from "../static/image/image2.jpg";
import image3 from "../static/image/image3.jpg";
import { NavLink } from "react-router-dom";

const Home = () => {
  const [index, setIndex] = useState(1);
  const [page, setPage] = useState(1);
  const [total, setTotal] = useState({});
  const [products, setProducts] = useState([]); // một cái hook usestate có 2 phần là , 

  useEffect(() => {
    getAllProducts(page, 12, true).then((response) => {
      setProducts(response.data.content);
    });
  });

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };
//xử lý sự kiện khi người dùng thay đổi trang
  const onChangePage = (page) => {
    setPage(page); //cập nhật giá trị của trang hiện tại
  };

  var rows = new Array(total).fill(0).map((zero, index) => (
    <li
      className={page === index + 1 ? "page-item active" : "page-item"}
      key={index}
    >
      <button
        className="page-link"
        style={{ borderRadius: 50 }}
        onClick={() => onChangePage(index + 1)}
      >
        {index + 1}
      </button>
    </li>
  ));
  
  return (
    <>
      <Carousel activeIndex={index} onSelect={handleSelect}>
        <Carousel.Item interval={500}>
          <img
            className="d-block w-100"
            src={image1}
            weight={1000}
            height={800}
            alt="First slide"
          />
        </Carousel.Item>
        <Carousel.Item interval={500}>
          <img
            className="d-block w-100"
            src={image2}
            weight={1000}
            height={800}
            alt="Second slide"
          />
        </Carousel.Item>
        <Carousel.Item interval={500}>
          <img
            className="d-block w-100"
            src={image3}
            weight={1000}
            height={800}
            alt="Second slide"
          />
        </Carousel.Item>
      </Carousel>

      <div className="mini-card">
        <div className="navbar navbar-expand-md col-12">
          <h4 className="title text-primary">Mới nhất</h4>
        </div>
      </div>

      <div className="col-11 container-fluid card">
      
      <div className="row padding">
      {products &&  
        products.map((item, index) => (
          <div className="col-md-4 mb-3" key={index}>
            <div className="card h-100">
              <div className="d-flex justify-content-between position-absolute w-100">
                <div className="label-new">
                  <span className="text-white bg-success small d-flex align-items-center px-2 py-1">
                    <i className="fa fa-star" aria-hidden="true"></i>
                    <span className="ml-1">New</span>
                  </span>
                </div>
              </div>

              <NavLink to={`/product-detail/${item.id}`}>
                <img
                  src={require(`../static/image/${item.image}`)}
                  style={{ width: 150, height: 150 }}
                  alt="Home"
                  className="mini-card"
                />
              </NavLink>

              <div className="card-body px-2 pb-2 pt-1">
                <div className="d-flex justify-content-between">
                  <div>
                    <p className="h4 text-primary">
                      {item.price.toLocaleString()} Đ
                    </p>
                  </div>
                </div>
                
                <p className="text-warning d-flex align-items-center mb-2">
                  <i className="fa fa-star" aria-hidden="true"></i>
                  <i className="fa fa-star" aria-hidden="true"></i>
                  <i className="fa fa-star" aria-hidden="true"></i>
                  <i className="fa fa-star" aria-hidden="true"></i>
                  <i className="fa fa-star" aria-hidden="true"></i>
                </p>
                <p className="mb-0">
                  <strong>
                    <NavLink
                      to={`/product-detail/${item.id}`}
                      className="text-secondary"
                    >
                      {item.name}
                    </NavLink>
                  </strong>
                </p>

                <p className="mb-1">
                  <small>
                    <NavLink to="#" className="text-secondary">
                      {item.brand}
                    </NavLink>
                  </small>
                </p>
                <div className="d-flex mb-3 justify-content-between">
                  <div>
                    <p className="mb-0 small">
                      <b>Yêu thích: </b> {item.view} lượt
                    </p>
                    <p className="mb-0 small">
                      <b>Giá gốc: </b> {item.price.toLocaleString()} Đ
                    </p>
                    <p className="mb-0 small text-danger">
                      <span className="font-weight-bold">
                        Tiết kiệm:{" "}
                      </span>{" "}
                      0 đ (0%)
                    </p>
                  </div>
                </div>
                
                <div className="d-flex justify-content-between">
                  <div className="col px-0">
                    <NavLink
                      to={`/product-detail/${item.id}`}
                      exact
                      className="btn btn-outline-primary btn-block"
                    >
                      Thêm vào giỏ
                      <i
                        className="fa fa-shopping-basket"
                        aria-hidden="true"
                      ></i>
                    </NavLink>
                  </div>
                  <div className="ml-2">
                    <NavLink
                      to="#"
                      className="btn btn-outline-success"
                      data-toggle="tooltip"
                      data-placement="left"
                      title="Add to Wishlist"
                    >
                      <i
                        className="fa fa-heart"
                        aria-hidden="true"
                      ></i>
                    </NavLink>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
    </div>
        
        <nav aria-label="Page navigation">
        <ul className="pagination offset-5 mt-3">
          <li className={page === 1 ? "page-item disabled" : "page-item"}>
            <button
              className="page-link"
              style={{ borderRadius: 50 }}
              onClick={() => onChangePage(1)}
            >
              {`<<`}
            </button>
          </li>

          {rows}

          <li className={page === total ? "page-item disabled" : "page-item"}>
            <button
              className="page-link"
              style={{ borderRadius: 50 }}
              onClick={() => onChangePage(total)}
            >
              {`>>`}
            </button>
          </li>
        </ul>
      </nav>
      </div>
    </>
  );
};

export default Home;
