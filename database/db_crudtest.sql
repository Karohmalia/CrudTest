--
-- PostgreSQL database dump
--

-- Dumped from database version 10.20
-- Dumped by pg_dump version 10.20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t1_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t1_position (
    id integer NOT NULL,
    code character varying(50) NOT NULL,
    is_delete integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.t1_position OWNER TO postgres;

--
-- Name: t2_employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t2_employee (
    id integer NOT NULL,
    birth_date timestamp without time zone NOT NULL,
    gender integer NOT NULL,
    id_number integer NOT NULL,
    is_delete integer NOT NULL,
    name character varying(100) NOT NULL,
    position_id integer NOT NULL
);


ALTER TABLE public.t2_employee OWNER TO postgres;

--
-- Name: t1_position t1_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t1_position
    ADD CONSTRAINT t1_position_pkey PRIMARY KEY (id);


--
-- Name: t2_employee t2_employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t2_employee
    ADD CONSTRAINT t2_employee_pkey PRIMARY KEY (id);


--
-- Name: t2_employee uk_2ykcumj64d6cb5u0jei1asubm; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t2_employee
    ADD CONSTRAINT uk_2ykcumj64d6cb5u0jei1asubm UNIQUE (id_number);


--
-- Name: t2_employee fklu6kxvp12604mla4h9nnt69k6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t2_employee
    ADD CONSTRAINT fklu6kxvp12604mla4h9nnt69k6 FOREIGN KEY (position_id) REFERENCES public.t1_position(id);


--
-- PostgreSQL database dump complete
--

