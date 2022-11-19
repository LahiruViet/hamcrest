package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


class HamcrestTest {

  @Test
  void test_check_if_single_element_is_in_a_collection() {

    List<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, hasItem("cd"));
    assertThat(collection, not(hasItem("zz")));
  }

  @Test
  void test_check_if_multiple_elements_are_in_a_collection() {

    List<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, hasItems("cd", "ef"));
  }

  @Test
  void test_check_all_elements_in_a_collection_with_strict_order() {

    List<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, contains("ab", "cd", "ef"));
  }

  @Test
  void test_check_all_elements_in_a_collection_with_any_order() {

    List<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, containsInAnyOrder("cd", "ab", "ef"));
  }

  @Test
  void test_check_if_collection_is_empty() {

    List<String> collection = Lists.newArrayList();
    assertThat(collection, empty());
  }

  @Test
  void test_check_if_array_is_empty() {

    String[] array = new String[] { "ab" };
    assertThat(array, not(emptyArray()));
  }

  @Test
  void test_check_if_map_is_empty() {

    Map<String, String> collection = Maps.newHashMap();
    assertThat(collection, equalTo(Collections.EMPTY_MAP));
  }

  @Test
  void test_check_if_iterable_is_empty() {

    Iterable<String> collection = Lists.newArrayList();
    assertThat(collection, emptyIterable());
  }

  @Test
  void test_check_size_of_a_collection() {

    List<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, hasSize(3));
  }

  @Test
  void test_check_size_of_an_iterable() {

    Iterable<String> collection = Lists.newArrayList("ab", "cd", "ef");
    assertThat(collection, Matchers.<String>iterableWithSize(3));
  }

  @Test
  void test_check_condition_on_every_item() {

    List<Integer> collection = Lists.newArrayList(15, 20, 25, 30);
    assertThat(collection, everyItem(greaterThan(10)));
  }

}
