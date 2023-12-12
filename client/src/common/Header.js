import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import logo from "../static/image/logo.jpg";
import Navbar from "react-bootstrap/Navbar";
import "../static/css/style.css";
import NavDropdown from "react-bootstrap/NavDropdown";
import { useNavigate } from "react-router-dom";
import "../App.css";

const Header = (props) => {
  const navigate = useNavigate(); // Khởi tạo hàm navigate

  const handleLoginClick = () => {
    // Điều hướng đến trang "Đăng Nhập" khi nút "Đăng Nhập" được nhấp
    navigate("/dangnhap");
  };
//hàm submitHandler xử lý sự kiện tìm kiếm bằng cách tránh làm mới trang, trích xuất từ khoá tìm kiếm và chuyển hướng người 
//dùng đến trang kết quả tìm kiếm.
  const submitHandler = (e) => {
    e.preventDefault();             // ngăn trình duyệt tự động tải lại trang
    props.searchHandler(e.target.keyword.value);  //gọi với từ khoá tìm kiếm mà người dùng đã nhập.
    navigate("/search");
  };

  return (
    <>
      <Navbar expand="lg" className="mini-card">
        <Container className="navbar navbar-expand-md col-12">

          <Navbar.Brand href="/" className="navbar-brand ml-1 col">
            <img src={logo} width="50" height="50" />
            <span>Shop Shoe NT</span>
          </Navbar.Brand>
          
          <Navbar.Toggle aria-controls="navbarScroll" />

          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "100px" }}
              navbarScroll
            >
              <Nav.Link href="/" className="nav-link">
                <Button variant="outline-primary">Trang Chủ</Button>
              </Nav.Link>

              <Nav.Link href="/sanpham" className="nav-link">
                <Button variant="outline-primary">Sản phẩm</Button>
              </Nav.Link>

              <Nav.Link href="/giohang" className="nav-link">
                <Button variant="outline-primary">Giỏ hàng </Button>
              </Nav.Link>
              
              <Nav.Link href="/lienhe" className="nav-link">
                <Button variant="outline-primary">Liên hệ</Button>
              </Nav.Link>
            </Nav>

            <Form className="d-flex" onSubmit={(e) => submitHandler(e)}>
              <input className="form-control mr-sm-2" type="search" aria-label="Search" name="keyword" />
              <Button variant="outline-success" type="submit">Search</Button>
            </Form>

            <Nav>
              <NavDropdown title="Tài Khoản" id="navbarScrollingDropdown">
                <NavDropdown.Item onClick={handleLoginClick}>Login</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#logout">Logout</NavDropdown.Item>
              </NavDropdown>
            </Nav>
            
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
};

export default Header;
