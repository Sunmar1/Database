<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<link rel='stylesheet' href='${model["app_path"]}/css/lab10.css'>
	<script src='${model["app_path"]}/js/lab10.js'></script>

	<title>Лабораторная работа 10</title>
</head>
<body>

<div class="menu-bar">
	<ul>
		<li><a class="active" href='${model["app_path"]}'>Главная</a></li>
		<li><a href='${model["app_path"]}/area/'>Участки</a></li>
		<li><a href='${model["app_path"]}/clinic/'>Клиники</a></li>
		<li><a href='${model["app_path"]}/doctor/'>Врачи</a></li>
		<li><a href='${model["app_path"]}/patient/'>Пациенты</a></li>
		<li><a href='${model["app_path"]}/diagnose/'>Диагнозы</a></li>
		<li><a href='${model["app_path"]}/deleteobject'>Удаление объектов</a></li>
		<li><a href='${model["app_path"]}/addobject'>Добавление объектов</a></li>




		<li style="float:right"><a href='${model["app_path"]}/logout'>Выход</a></li>
	</ul>
</div>

<div class="c-wrapper">

	<H2>
		ПОЛИКЛИНИКА
	</H2>
    <br>Предметная область - ПОЛИКЛИНИКА	</br>
	<p><strong>Сущности:</strong>
	<ul>
		<li>Участок</li>
		<li>Поликлиника</li>
		<li>Диангозы</li>
		<li>Врачи</li>
		<li>Пациенты</li>
	</ul>

	<p><strong>Классы:</strong>
	<p>Описание участка <br>
		@Entity<br>
		public class Area {<br>
		@Id<br>
		@GeneratedValue(strategy = GenerationType.IDENTITY)<br>
		private Long id;<br>
		@Column<br>
		private String name;<br>
		}<br>

	<p>Описание Поликники <br>
		@Entity<br>
		public class Clinic {<br>
		@Column<br>
		String name;<br>
		@Column<br>
		String address;<br>
		@Column<br>
		@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)<br>
		List<Area> areas = new ArrayList();<br>
		@Column<br>
		@OneToMany<br>
		List<Doctors> doctors = new ArrayList(); <br>
			@Column<br>
			@OneToMany<br>
			protected List<Patient> patients = new ArrayList();<br>
				@Id<br>
				@GeneratedValue(strategy = GenerationType.IDENTITY)<br>
				private Long id;<br>
				}<br>
	<p>Описание Диагноза <br>

		@Entity<br>
		public class Diagnose {<br>
		@Id<br>
		@GeneratedValue(strategy = GenerationType.IDENTITY)<br>
		private Long id;<br>
		@Column<br>
		public String name;<br>
	   }<br>
	<p>Описание Врачи <br>

		@Entity <br>
		public class Doctors extends Person { <br>

		@ManyToOne <br>
		Area area; <br>
		@Column <br>
		String specialty; <br>
		@Id <br>
		@GeneratedValue(strategy = GenerationType.IDENTITY) <br>
		private Long id; <br>
		}<br>

		@Entity<br>
		@Inheritance(strategy = InheritanceType.JOINED)<br>
		public abstract class Person {<br>
		@Column<br>
		String name;<br>
		@Column<br>
		Date birthDate;<br>
		@Id<br>
		@GeneratedValue(strategy = GenerationType.IDENTITY)<br>
		private Long id;<br>
		}<br>

	<p>Описание Пациенты <br>
		@Entity<br>
		public class Patient extends Person {<br>

		@ManyToOne<br>
		Area area;<br>

		@OneToMany<br>
		List<Diagnose> diagnoses=new ArrayList<>();<br>
			@Id<br>
			private Long id;<br>
			}<br>

	<p><strong>Структура БД:</strong>
		CREATE TABLE public.area<br>
		(<br>
		id integer NOT NULL DEFAULT nextval('area_id_seq'::regclass),<br>
		name character varying(255) COLLATE pg_catalog."default",<br>
		CONSTRAINT area_pkey PRIMARY KEY (id)<br>
		)<br>

		CREATE TABLE public.clinic<br>
		(<br>
		id integer NOT NULL DEFAULT nextval('clinic_id_seq'::regclass),<br>
		address character varying(255) COLLATE pg_catalog."default",<br>
		name character varying(255) COLLATE pg_catalog."default",<br>
		CONSTRAINT clinic_pkey PRIMARY KEY (id)<br>
		)<br>

		CREATE TABLE public.clinic_area<br>
		(<br>
		clinic_id integer NOT NULL DEFAULT nextval('clinic_area_clinic_id_seq'::regclass),<br>
		areas_id bigint NOT NULL,<br>
		CONSTRAINT clinic_area_pkey PRIMARY KEY (clinic_id),<br>
		CONSTRAINT uk_cd3a8wko5yys4lte5dx8busssy UNIQUE (areas_id)<br>
		,<br>
		CONSTRAINT fkce5ny5gvk0f7m8e3nk07h4asr FOREIGN KEY (areas_id)<br>
		REFERENCES public.area (id) MATCH SIMPLE<br>
		ON UPDATE NO ACTION<br>
		ON DELETE NO ACTION<br>
		NOT VALID<br>
		)<br>

		CREATE TABLE public.clinic_doctors<br>
		(<br>
		clinic_id integer NOT NULL DEFAULT nextval('clinic_doctors_clinic_id_seq'::regclass),<br>
		doctors_id bigint NOT NULL,<br>
		CONSTRAINT clinic_doctors_pkey PRIMARY KEY (clinic_id),<br>
		CONSTRAINT uk_cd3a8wko5yys4lte5dx8buqay UNIQUE (doctors_id)<br>
		,<br>
		CONSTRAINT fkce5ny5gvk0f7m8e3nk07h4asr FOREIGN KEY (doctors_id)<br>
		REFERENCES public.doctors (id) MATCH SIMPLE<br>
		ON UPDATE NO ACTION<br>
		ON DELETE NO ACTION<br>
		NOT VALID<br>
		)<br>


		CREATE TABLE public.clinic_doctors<br>
		<br>(
		<br>clinic_id integer NOT NULL DEFAULT nextval('clinic_doctors_clinic_id_seq'::regclass),
		<br>doctors_id bigint NOT NULL,
		<br>CONSTRAINT clinic_doctors_pkey PRIMARY KEY (clinic_id),
		<br>CONSTRAINT uk_cd3a8wko5yys4lte5dx8buqay UNIQUE (doctors_id)
		<br>,
		<br>CONSTRAINT fkce5ny5gvk0f7m8e3nk07h4asr FOREIGN KEY (doctors_id)
		<br>REFERENCES public.doctors (id) MATCH SIMPLE
		<br>ON UPDATE NO ACTION
		<br>ON DELETE NO ACTION
		<br>NOT VALID
		<br>)<br>

		CREATE TABLE public.clinic_patient<br>
		(<br>
		clinic_id integer NOT NULL DEFAULT nextval('clinic_patient_clinic_id_seq'::regclass),<br>
		patients_id bigint NOT NULL,<br>
		CONSTRAINT clinic_patient_pkey PRIMARY KEY (clinic_id),<br>
		CONSTRAINT uk_kjpumi4pelu221ltbxkxgvkpe UNIQUE (patients_id)<br>
		,<br>
		CONSTRAINT fkqucxxsclfxwqbmqfj1lnxlw8o FOREIGN KEY (patients_id)<br>
		REFERENCES public.patient (id) MATCH SIMPLE<br>
		ON UPDATE NO ACTION<br>
		ON DELETE NO ACTION<br>
		NOT VALID<br>
		)<br>

		CREATE TABLE public.diagnose<br>
		(<br>
		id integer NOT NULL DEFAULT nextval('diagnose_id_seq'::regclass),<br>
		name character varying(255) COLLATE pg_catalog."default",<br>
		CONSTRAINT diagnoses_pkey PRIMARY KEY (id)<br>
		)
		<br>
		CREATE TABLE public.diagnose<br>
		(<br>
		id integer NOT NULL DEFAULT nextval('diagnose_id_seq'::regclass),<br>
		name character varying(255) COLLATE pg_catalog."default",<br>
		CONSTRAINT diagnoses_pkey PRIMARY KEY (id)<br>
		)<br>

		CREATE TABLE public.doctors<br>
		(<br>
		id bigint NOT NULL,<br>
		specialty character varying(255) COLLATE pg_catalog."default",<br>
		area_id bigint,<br>
		CONSTRAINT doctors_pkey PRIMARY KEY (id)<br>
		)<br>

		CREATE TABLE public.patient<br>
		(<br>
		id bigint NOT NULL,<br>
		area_id bigint,<br>
		CONSTRAINT patient_pkey PRIMARY KEY (id)<br>
		)<br>

		CREATE TABLE public.patient_diagnoses<br>
		(<br>
		patient_id integer NOT NULL DEFAULT nextval('patient_diagnoses_patient_id_seq'::regclass),<br>
		diagnoses_id bigint NOT NULL,<br>
		CONSTRAINT patient_diagnoses_pkey PRIMARY KEY (patient_id),<br>
		CONSTRAINT uk_odi5ybp4gy64eo4h7ly02olx0 UNIQUE (diagnoses_id)<br>
		,<br>
		CONSTRAINT fkrlt1rg6pskc3cgki3dp0ocjm1 FOREIGN KEY (patient_id)<br>
		REFERENCES public.patient (id) MATCH SIMPLE<br>
		ON UPDATE NO ACTION<br>
		ON DELETE NO ACTION<br>
		NOT VALID<br>
		)<br>


		CREATE TABLE public.person<br>
		(<br>
		id integer NOT NULL DEFAULT nextval('person_id_seq'::regclass),<br>
		name text COLLATE pg_catalog."default" NOT NULL,<br>
		birthdate date,<br>
		CONSTRAINT person_pkey PRIMARY KEY (id)<br>
		)<br>





	<p><strong>Представление:</strong><br>
		@Entity<br>
		public class DoctorsData {<br>
		@Id<br>
		private Long id;<br>
		private String name;<br>
    	}<br>
		<br>
		create view DoctorsData as<br>
		select c.id, p.name from doctors c join person p on c.id=p.id;<br>




</div>
</body>
</html>