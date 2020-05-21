//package com.lake.smartway.lombok;
//
//
//@Data
///**
// * @Data (Lombok)
// * 클래스안의 모든 private 필드에 대해 @Getter와 @Setter를 적용하여 세터/게터를 만들어주고
// * 클래스내에 @ToString 과 @EqualsAndHashCode를 적용시켜 메소드를 오버라이드 해주며
// * @RequiredArgsConstructor를 지정해 준다. << 보통 final과 @NonNull이 없는 경우가 많아서 기본생성자가 생김 (@NoArgsConstructor라고 착각하면 안됨)
// */
//@Entity //JPA 설정
///**
// * @Entity (JPA)
// * 테이블과 1:1로 매칭되는 Entity객체
// * primary key에 @Id를 붙힘
// * spring.jpa.hibernate.ddl-auto=create-drop 설정시 서버 구동시 DDL 쿼리 자동 수행
// * 객체명의 CamelCase형태의 테이블명을 그대로 갖지만 @Entity(name = "테이블명") 테이블명을 작성하는게 관례임
// * 해당 객체 안에 변수들에 @Column 자동으로 붙혀줌
// */
//@NoArgsConstructor //NoArgsConstructor 기본 생성자 생성
//@AllArgsConstructor //AllArgsConstructor모든 값있는 생성자 생성
////@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 생성
//@Builder // 빌더패턴
//public class SampleAccount {
//    //5280
//    @Id
//    @GeneratedValue
//    @Column(name = "ACCOUNT_ID")
//    private Long id;
//    @NotNull
//    @Column(nullable = false, unique = true)
//    private String userName;
//    @JsonInclude(JsonInclude.Include.NON_NULL) //Json 보낼때 히든처리
//    private String password;
//    @NotNull
//    @Column(nullable = false, unique = true)
//    private String email;
//}