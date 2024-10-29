<script lang="ts">
  import Modal from '$lib/components/Modal.svelte';
import Notice from '$lib/components/Notice.svelte';
  import Spacer from '$lib/components/Spacer.svelte';
  import TextBox from '$lib/components/TextBox.svelte';
  import { deportal } from '$lib/utility/svelte';
  import { InfoIcon, AlertTriangleIcon, ArrowUpRightIcon } from 'svelte-feather-icons';

  let showLinkModal = false;
</script>

<div class="space-y-4">
  <div class="flex flex-row justify-between">
    <h2 class="text-2xl">You</h2>
    <button class="text-base" aria-label="Logout">Logout</button>
  </div>

  <div class="space-y-2">
    <div class="flex flex-row space-x-4 text-lg font-semibold ">
      <p class="text-gray-500">Auth</p>
      <p>Google</p>
    </div>

    <div class="flex flex-row space-x-4 text-lg font-semibold ">
      <p class="text-gray-500">ID</p>
      <p>example@example.org</p>
    </div>
  </div>

  <button class="danger text-base w-full" aria-label="Unregister account">Unregister Account</button>
</div>

<Spacer />

<div class="space-y-4">
  <div class="flex flex-row justify-between">
    <h2 class="text-2xl">Minecraft</h2>
    <button class="text-base" on:click={() => showLinkModal = !showLinkModal} aria-label="Link Minecraft account">Link</button>
    {#if showLinkModal}
      <Modal id="link">
        <div class="flex flex-row justify-between">
          <h2 class="text-2xl">Minecraft</h2>
          <button on:click={() => { deportal("link"); showLinkModal = false }}>Cancel</button>
        </div>

        <TextBox class="text-center">Link your Minecraft account using one of the providers below.</TextBox>

        <div class="space-y-4">
          <button class="w-full">
            <p>Microsoft</p>
            <ArrowUpRightIcon size={'24'} />
          </button>
  
          <button class="w-full">
            <p>Unofficial Player</p>
            <ArrowUpRightIcon size={'24'} />
          </button>
        </div>
      </Modal>
    {/if}
  </div>

  <Notice type="warn">
    <AlertTriangleIcon size={'30'} />
    <p class="text-center">No Minecraft account linked.</p>
  </Notice>
</div>

<Spacer />

<div class="space-y-4">
  <div class="flex flex-row justify-between items-center">
    <div>
      <h2 class="text-2xl">Guests</h2>
      <p class="italic">Used Slots: 0 / 3</p>
    </div>
    <button class="text-base" aria-label="Create guest invite link">Add</button>
  </div>

  <Notice>
    <InfoIcon size={'30'} />
    <p>You will be held responsible for those you invite.</p>
  </Notice>
</div>