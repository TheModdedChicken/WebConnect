<script lang="ts">
  import { portal } from '$lib/utility/svelte';
  import type { Snippet } from 'svelte';

  interface Props {
    children: Snippet<[]>
    class?: string

    id: string
  }

  let { 
    children,
    class: external_class = "",

    id
  }: Props = $props();
</script>

<div id={"modal-" + id} use:portal class={"modal p-6 bg-white rounded-lg space-y-6 " + external_class}>
  {@render children()}
</div>